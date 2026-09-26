import java.util.Scanner;

// Common behaviour shared by every vehicle type: calculating the parking charge
interface Vehicle {
    double getCharge(int hours);
}

class Bike implements Vehicle {
    public double getCharge(int hours) {
        // Rs.10 per hour
        return hours * 10.0;
    }
}

class Car implements Vehicle {
    public double getCharge(int hours) {
        // Rs.30 for the first hour, Rs.20 for each additional hour
        if (hours <= 1) {
            return 30.0;
        }
        return 30.0 + (hours - 1) * 20.0;
    }
}

class Truck implements Vehicle {
    public double getCharge(int hours) {
        // Rs.50 per hour, minimum charge Rs.100
        double charge = hours * 50.0;
        return Math.max(charge, 100.0);
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle;
            if (type.equals("BIKE")) {
                vehicle = new Bike();
            } else if (type.equals("CAR")) {
                vehicle = new Car();
            } else {
                vehicle = new Truck();
            }

            double charge = vehicle.getCharge(hours);
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
