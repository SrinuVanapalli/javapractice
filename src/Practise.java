

import java.util.*;

 class Employee {
    private int id;
    private String name;
    private int salary;
    private String type;

    public Employee(int id, String name, int salary, String type) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.type = type;
    }
    public int getId() { return id;}
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "\nEmployee ID : " + id +
                "\nEmployee Name : " + name +
                "\nSalary : " + salary +
                "\nEmployee Type : " + type ;
    }
}


 class EmployeeData {

    public static void main(String[] args) {

        Map<Integer, List<Employee>> employeeMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {

            System.out.println("Enter Employee ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee Name:");
            String name = sc.nextLine();

            System.out.println("Enter Employee Salary:");
            int salary = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Employee Type:");
            String type = sc.nextLine();

            Employee emp = new Employee(id, name, salary, type);
            List<Employee> employeeList = employeeMap.get(id);
            if (employeeList == null) {
                employeeList = new ArrayList<>();
                employeeMap.put(id, employeeList);
            }
            employeeList.add(emp);

            System.out.println("Press 1 to Continue and 0 to Exit");
            int choice = sc.nextInt();
            if (choice == 0) {
                flag = false;
            }
        }

        Iterator<Map.Entry<Integer, List<Employee>>> mapIterator = employeeMap.entrySet().iterator();

        while (mapIterator.hasNext()) {
            Map.Entry<Integer, List<Employee>> entry = mapIterator.next();

            Iterator<Employee> empIterator = entry.getValue().iterator();
            while (empIterator.hasNext()) {
                Employee emp = empIterator.next();
                System.out.println(emp);
            }
        }

        System.out.println("Enter Employee ID to Search:");
        int searchId = sc.nextInt();
        if (employeeMap.containsKey(searchId)) {
            System.out.println("Employee Details");

            Iterator<Employee> iterator = employeeMap.get(searchId).iterator();
            while (iterator.hasNext()) {
                Employee emp = iterator.next();
                System.out.println(emp);
            }
        } else {
            System.out.println("Employee ID Not Found.");
        }
        sc.close();
    }
}









