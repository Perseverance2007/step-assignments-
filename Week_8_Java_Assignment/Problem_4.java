import java.util.Scanner;

// Common behaviour shared by every employee type: calculating the bonus
interface Employee {
    double getBonus();
    String getName();
}

class FullTime implements Employee {
    private String name;
    private double salary;

    public FullTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getBonus() {
        // 10% of monthly salary
        return salary * 0.10;
    }

    public String getName() {
        return name;
    }
}

class PartTime implements Employee {
    private String name;
    private double salary;

    public PartTime(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getBonus() {
        // 5% of monthly salary
        return salary * 0.05;
    }

    public String getName() {
        return name;
    }
}

class Intern implements Employee {
    private String name;
    private double salary;

    public Intern(String name, double salary) {
        this.name = name;
        this.salary = salary; // not used for bonus, but kept for consistency
    }

    public double getBonus() {
        // Fixed bonus regardless of salary
        return 2000.0;
    }

    public String getName() {
        return name;
    }
}

public class Problem_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee;
            if (type.equals("FULLTIME")) {
                employee = new FullTime(name, salary);
            } else if (type.equals("PARTTIME")) {
                employee = new PartTime(name, salary);
            } else {
                employee = new Intern(name, salary);
            }

            double bonus = employee.getBonus();
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
