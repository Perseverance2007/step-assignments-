import java.util.Scanner;

// Common behaviour shared by every room type: calculating the bill
interface Room {
    double calculateBill();
}

class SingleRoom implements Room {
    private double units;

    public SingleRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        // Rs.8 per unit
        return units * 8.0;
    }
}

class SharedRoom implements Room {
    private double units;
    private int occupants;

    public SharedRoom(double units, int occupants) {
        this.units = units;
        this.occupants = occupants;
    }

    public double calculateBill() {
        // Rs.6 per unit, split equally among occupants
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    private double units;

    public ACRoom(double units) {
        this.units = units;
    }

    public double calculateBill() {
        // Rs.10 per unit plus fixed Rs.200 charge
        return (units * 10.0) + 200.0;
    }
}

public class Problem_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double units = Double.parseDouble(parts[1]);

            Room room;
            if (type.equals("SINGLE")) {
                room = new SingleRoom(units);
            } else if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(parts[2]);
                room = new SharedRoom(units, occupants);
            } else {
                room = new ACRoom(units);
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
