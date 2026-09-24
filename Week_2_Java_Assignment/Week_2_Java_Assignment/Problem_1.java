import java.util.Scanner;

/*
 * Problem 1: ATM PIN Length Validator
 * Checks that a PIN string is exactly 4 digits long.
 */
public class Problem_1 {

    public static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();
        checkPinLength(pin);
        sc.close();
    }
}
