/**
 * Problem 3 - Employee Profile Creation (M3)
 * Demonstrates constructor chaining with this(...): the intern constructor
 * reuses the permanent-employee constructor instead of duplicating setup logic.
 */
class EmployeeProfile {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public EmployeeProfile(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns - chains to the 3-argument constructor
    public EmployeeProfile(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        EmployeeProfile permanent = new EmployeeProfile("E-101", "Divya", 65000);
        EmployeeProfile intern = new EmployeeProfile("E-102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}
