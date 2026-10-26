import java.sql.*;
import java.util.*;

 class State {

    private int stateId;
    private String stateName;

    public State(int stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }
    public int getStateId() { return stateId; }
    public String getStateName() { return stateName; }

    @Override
    public String toString() {
        return stateId + " - " + stateName;
    }
}

class District {

    private int districtId;
    private String districtName;

    public District(int districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }
    public int getDistrictId() {
        return districtId;
    }
    public String getDistrictName() { return districtName; }
    @Override
    public String toString() {
        return districtId + " - " + districtName;
    }
}

public class JdbcCountryMap {



    static HashMap<Integer, String> countryMap = new HashMap<>();

    static HashMap<Integer, List<State>> stateMap = new HashMap<>();

    static HashMap<Integer, Map<Integer, List<District>>> countryStateMap = new HashMap<>();

    public static void loadCountries(Connection con) throws SQLException {

        String query = "SELECT * FROM jdbc_practice.COUNTRY";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            int countryId = rs.getInt("CID");
            String countryName = rs.getString("COUNTRY");
            countryMap.put(countryId, countryName);
        }
        rs.close();
        ps.close();
    }

    public static void loadStates(Connection con) throws SQLException {

        String query = "SELECT * FROM jdbc_practice.STATE";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int stateId = rs.getInt("STID");
            String stateName = rs.getString("STATE");
            int countryId = rs.getInt("CID");

            State state = new State(stateId, stateName);

            if (!stateMap.containsKey(countryId)) {
                stateMap.put(countryId, new ArrayList<>());
            }
            stateMap.get(countryId).add(state);
        }
        rs.close();
        ps.close();
    }

    public static void loadDistricts(Connection con) throws SQLException {

        String query =
                "SELECT s.CID, d.STID, d.DSID, d.DISTRICT " +
                        "FROM jdbc_practice.DISTRICT d " +
                        "JOIN jdbc_practice.STATE s ON d.STID = s.STID";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            int countryId = rs.getInt("CID");
            int stateId = rs.getInt("STID");
            int districtId = rs.getInt("DSID");
            String districtName = rs.getString("DISTRICT");

            District district = new District(districtId, districtName);

            countryStateMap
                    .computeIfAbsent(countryId, k -> new HashMap<>())
                    .computeIfAbsent(stateId, k -> new ArrayList<>())
                    .add(district);
        }

        rs.close();
        ps.close();
    }

    public static void menu() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==============================");
            System.out.println("1. Show Countries");
            System.out.println("0. Exit");
            System.out.println("==============================");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Countries");

                    for (Map.Entry<Integer, String> entry : countryMap.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }

                    System.out.print("\nEnter Country ID : ");
                    int countryId = sc.nextInt();
                    List<State> states = stateMap.get(countryId);

                    if (states == null) {
                        System.out.println("No States Found.");
                        break;

                    }

                    System.out.println("\nStates");

                    for (State state : states) {
                        System.out.println(state);
                    }

                    System.out.print("\nEnter State ID : ");
                    int stateId = sc.nextInt();

                    Map<Integer, List<District>> stateDistrictMap = countryStateMap.get(countryId);

                    if (stateDistrictMap == null) {
                        System.out.println("No States Found.");
                        break;
                    }

                    List<District> districts = stateDistrictMap.get(stateId);

                    if (districts == null) {
                        System.out.println("Invalid State ID for the selected Country.");
                        break;
                    }

                    System.out.println("\nDistricts");

                    for (District district : districts) {
                        System.out.println(district);
                    }
                    break;

                case 0:
                    System.out.println("Thank You");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public static void main(String[] args) {
             SqlConnection get = new SqlConnection();
        try {
            Connection con = get.getConnection();
            loadCountries(con);
            loadStates(con);
            loadDistricts(con);

            System.out.println("Country Map:");
            System.out.println(countryMap);

            System.out.println("\nState Map:");
            System.out.println(stateMap);

            System.out.println("\nCountry-State-District Map:");
            System.out.println(countryStateMap);

            menu();
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}