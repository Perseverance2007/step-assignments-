import java.util.Scanner;

// Every student has a name and a tuition rule
abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract double getTuition();
}

// Only some students use the college bus; the transport fee is written once here
interface BusUser {
    double TRANSPORT_FEE = 12000;
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000; // tuition + hostel fee
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuition() {
        return 20000; // half of the normal tuition
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            Student student;
            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getTuition();
            // Ask the student: "do you use the bus?"
            if (student instanceof BusUser) {
                fee += BusUser.TRANSPORT_FEE;
            }

            System.out.printf("%s: %.2f%n", student.getName(), fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
