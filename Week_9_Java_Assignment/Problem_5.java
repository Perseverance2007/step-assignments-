import java.util.Scanner;

// What every appliance shares: a power rating and the way units are calculated
abstract class Appliance {
    static final double RATE_PER_UNIT = 8;

    abstract double getPowerWatts();

    double getUnits(double hours) {
        return getPowerWatts() * hours / 1000;
    }
}

// Only some appliances have a saver mode
interface SaverMode {
    double SAVER_REDUCTION = 0.25; // 25% less energy
}

class Fridge extends Appliance {
    double getPowerWatts() {
        return 150;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    double getPowerWatts() {
        return 1500;
    }
}

class Tv extends Appliance {
    double getPowerWatts() {
        return 100;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    double getPowerWatts() {
        return 500;
    }
}

public class Problem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance;
            if (type.equals("FRIDGE")) {
                appliance = new Fridge();
            } else if (type.equals("AC")) {
                appliance = new AirConditioner();
            } else if (type.equals("TV")) {
                appliance = new Tv();
            } else {
                appliance = new WashingMachine();
            }

            double units = appliance.getUnits(hours);

            if (saverRequested) {
                // Ask the appliance: "do you support saver mode?"
                if (appliance instanceof SaverMode) {
                    units = units - units * SaverMode.SAVER_REDUCTION;
                } else {
                    System.out.println(type + ": saver mode not supported");
                    continue; // reported instead of calculating a cost
                }
            }

            double cost = units * Appliance.RATE_PER_UNIT;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
