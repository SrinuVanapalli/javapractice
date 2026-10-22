/*Retrieve all Universities*/

import java.sql.*;


class University{
  private int UniversityId ;
  private String UniversityName;

  public University(int UniversityId, String UniversityName ){
      this.UniversityId = UniversityId;
      this.UniversityName = UniversityName;

  }

  public int getInt(){ return UniversityId;}
    public String getString(){ return UniversityName ;}

    @Override
    public String toString(){ return  UniversityId +" - "+ UniversityName;}
}


public class JdbcGetAllUniversities{

    public static void main(String[] args){
          SqlConnection get = new SqlConnection();
      try {
         Connection con = get.getConnection();

        String query = "Select u.UID, u.UNIVERSITYNAME FROM jdbc_practice.UNIVERSITY u;";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){

            int UniID = rs.getInt("UID");
            String UniName = rs.getString("UNIVERSITYNAME");

            System.out.println(UniID + " - " + UniName);

        }
        rs.close();
        ps.close();
        con.close();

      }catch(Exception e){
        e.printStackTrace();
      }
    }
}