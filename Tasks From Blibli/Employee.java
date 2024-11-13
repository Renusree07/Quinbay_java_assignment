import java.util.Date;
import java.util.Calendar;

public class Employee {
    private String id;
    private String name;
    private int age;
    private Date dateOfJoining;

    public Employee(String id, String name, int age, Date dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', age=" + age + ", dateOfJoining=" + dateOfJoining + "}";
    }

    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // month is 0-indexed in Calendar
        return cal.getTime();
    }
}
 class Main {
    public static void main(String[] args) {
        GenericMyList<Employee> employeeList = new GenericMyList<>();

        // Correct way of creating a Date object using the createDate method
        Employee emp1 = new Employee("E001", "Alice", 30, Employee.createDate(2020, 5, 10));
        Employee emp2 = new Employee("E002", "Bob", 28, Employee.createDate(2021, 3, 15));
        Employee emp3 = new Employee("E003", "Charlie", 35, Employee.createDate(2019, 8, 25));

        // Adding employees to the list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        // Printing list after adding employees
        System.out.println("Employee list after adding:");
        employeeList.printList();

        // Deleting an employee by index (1)
        employeeList.deleteByIndex(1);
        System.out.println("Employee list after deleting by index (1):");
        employeeList.printList();

        // Deleting an employee by value (emp3)
        employeeList.deleteByValue(emp3);
        System.out.println("Employee list after deleting by value (emp3):");
        employeeList.printList();
    }
}
