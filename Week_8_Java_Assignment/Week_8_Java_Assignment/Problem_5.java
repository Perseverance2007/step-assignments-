import java.time.LocalDate;
import java.util.Scanner;

// Common behaviour shared by every plan type: validity period in days
interface Plan {
    int getValidityDays();
}

class Basic implements Plan {
    public int getValidityDays() {
        return 30;
    }
}

class Standard implements Plan {
    public int getValidityDays() {
        return 90;
    }
}

class Premium implements Plan {
    public int getValidityDays() {
        return 365;
    }
}

public class Problem_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            Plan plan;
            if (type.equals("BASIC")) {
                plan = new Basic();
            } else if (type.equals("STANDARD")) {
                plan = new Standard();
            } else {
                plan = new Premium();
            }

            LocalDate renewalDate = startDate.plusDays(plan.getValidityDays());
            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}
