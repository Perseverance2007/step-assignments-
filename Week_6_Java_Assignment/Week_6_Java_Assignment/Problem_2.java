/**
 * Problem 2 - Payroll Salary Management (M2)
 * basicSalary and bonus are private and can never be set directly from
 * outside the class; every change goes through a validated method.
 */
class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Negative opening salary given. Starting at 0 instead.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount: must be greater than 0.");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percent: must be between 0 and 100.");
            return;
        }
        basicSalary = basicSalary - (basicSalary * percent / 100);
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Problem_2 {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
