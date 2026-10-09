import java.util.Scanner;

// Common behaviour shared by every customer type: calculating the final amount
interface Customer {
    double getFinalAmount(double billAmount);
}

class Student implements Customer {
    public double getFinalAmount(double billAmount) {
        // 10% discount
        return billAmount - (billAmount * 0.10);
    }
}

class Staff implements Customer {
    public double getFinalAmount(double billAmount) {
        // 5% discount
        return billAmount - (billAmount * 0.05);
    }
}

class Guest implements Customer {
    public double getFinalAmount(double billAmount) {
        // Full amount plus Rs.10 service charge
        return billAmount + 10;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            // Only the object creation needs to know the type.
            // The billing calculation itself uses polymorphism (no if-else there).
            Customer customer;
            if (type.equals("STUDENT")) {
                customer = new Student();
            } else if (type.equals("STAFF")) {
                customer = new Staff();
            } else {
                customer = new Guest();
            }

            double finalAmount = customer.getFinalAmount(amount);
            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
