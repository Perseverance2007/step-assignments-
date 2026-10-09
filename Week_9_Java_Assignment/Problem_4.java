import java.util.Scanner;

// Rules shared by every cab live in the abstract class
abstract class Cab {
    static final double MINIMUM_FARE = 100; // one rule for all cabs, written once

    abstract double getRatePerKm();

    double getFare(double km) {
        double fare = km * getRatePerKm();
        if (fare < MINIMUM_FARE) {
            fare = MINIMUM_FARE;
        }
        return fare;
    }
}

// Night service is an ability that only some cabs choose to have
interface NightService {
    double NIGHT_SURCHARGE = 0.20; // 20%
}

class MiniCab extends Cab {
    double getRatePerKm() {
        return 10;
    }
}

class SedanCab extends Cab implements NightService {
    double getRatePerKm() {
        return 14;
    }
}

class SuvCab extends Cab implements NightService {
    double getRatePerKm() {
        return 18;
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
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab;
            if (type.equals("MINI")) {
                cab = new MiniCab();
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab();
            } else {
                cab = new SuvCab();
            }

            double fare = cab.getFare(km); // minimum fare already applied

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = fare + fare * NightService.NIGHT_SURCHARGE;
                } else {
                    System.out.println(type + ": night service not available");
                    continue; // rejected trip is not added to the total
                }
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
