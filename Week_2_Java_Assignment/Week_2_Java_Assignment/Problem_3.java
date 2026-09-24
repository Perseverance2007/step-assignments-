import java.util.Scanner;

/*
 * Problem 3: Product Inventory CSV Parser
 * Splits a CSV line "ProductName,SKU,Quantity" into fields and
 * prints a formatted record, validating exactly 3 fields exist.
 */
public class Problem_3 {

    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV line: ");
        String csvLine = sc.nextLine();
        parseInventoryRecord(csvLine);
        sc.close();
    }
}
