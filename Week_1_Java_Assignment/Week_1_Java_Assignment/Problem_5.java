import java.util.Scanner;

/*
 * Problem 5: The Movie Review Word Length Profiler
 * Splits a review into words and classifies each as Short (1-4),
 * Medium (5-8), or Long (9+) letters, then prints the counts.
 */
public class Problem_5 {

    public static void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len == 0) {
                continue;
            }
            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        String review = sc.nextLine();
        classifyWordLengths(review);
        sc.close();
    }
}
