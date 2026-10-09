import java.util.Scanner;

// Every parcel has a weight, a declared value and a shipping charge
abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();
}

// Only some parcels can be insured, so insurance is a separate ability (interface)
interface Insurable {
    double INSURANCE_RATE = 0.02; // 2% of declared value, written once

    double getInsurance();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

// Fragile = standard charge + handling fee of 50
class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double getCharge() {
        return super.getCharge() + 50;
    }

    public double getInsurance() {
        return declaredValue * INSURANCE_RATE;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double value = Double.parseDouble(parts[2]);

            Parcel parcel;
            if (type.equals("STANDARD")) {
                parcel = new StandardParcel(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcel = new ExpressParcel(weight, value);
            } else {
                parcel = new FragileParcel(weight, value);
            }

            double charge = parcel.getCharge();
            double insurance = 0.0;
            // Ask the parcel: "can you be insured?"
            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).getInsurance();
            }
            double total = charge + insurance;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);
            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
