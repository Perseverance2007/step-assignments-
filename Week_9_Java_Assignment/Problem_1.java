import java.util.Scanner;

// A plain "ticket" must never be sold, so Ticket is abstract (cannot be created with new)
abstract class Ticket {
    // The convenience fee is written in ONE place only
    static final double CONVENIENCE_FEE = 20;

    // Each seat type decides its own price
    abstract double getPrice();

    // Common part: same for every seat type
    double getAmount(int count) {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    double getPrice() {
        return 150;
    }
}

class PremiumTicket extends Ticket {
    double getPrice() {
        return 250;
    }
}

class ReclinerTicket extends Ticket {
    double getPrice() {
        return 400;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0];
            int count = Integer.parseInt(parts[1]);

            Ticket ticket;
            if (seat.equals("REGULAR")) {
                ticket = new RegularTicket();
            } else if (seat.equals("PREMIUM")) {
                ticket = new PremiumTicket();
            } else {
                ticket = new ReclinerTicket();
            }

            double amount = ticket.getAmount(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
