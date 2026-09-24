/**
 * Problem 5 - Employee and Company Information Management (M5)
 * companyName and employeeCount are static, so every Employee object
 * shares ONE copy instead of each carrying its own copy of the company name.
 */
class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static method: must not reference any instance field
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Problem_5 {
    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 40000);
        new Employee("Rahul", 50000);

        System.out.println(Employee.employeeCount + " Employee objects created");
        Employee.printCompanyInfo();
    }
}
