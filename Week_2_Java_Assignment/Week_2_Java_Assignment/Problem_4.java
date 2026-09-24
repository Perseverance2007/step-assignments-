import java.util.Scanner;

/*
 * Problem 4: Library ISBN Normalizer & Validator
 * Normalizes a code by trimming spaces and uppercasing the first 3
 * characters, then validates it is exactly 13 characters: 3 letters
 * (publisher code) + 4 digits (year) + 6 digits (catalog number).
 */
public class Problem_4 {

    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();

        if (trimmed.length() < 3) {
            return trimmed;
        }

        String firstThree = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);

        return firstThree + rest;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisher = code.substring(0, 3);
        String body = code.substring(3);

        for (int i = 0; i < publisher.length(); i++) {
            if (!Character.isLetter(publisher.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining 10 characters must be digits";
            }
        }

        String year = body.substring(0, 4);
        String catalog = body.substring(4);

        StringBuilder display = new StringBuilder();
        display.append("[").append(publisher).append("] YEAR: ").append(year)
                .append(" | CATALOG: ").append(catalog);

        return display.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter raw code: ");
        String raw = sc.nextLine();
        String normalized = normalizeCode(raw);
        System.out.println(validateAndFormat(normalized));
        sc.close();
    }
}
