/**
 * Problem 4 - Match Day Grid Analyzer
 * Classifies each match's over-by-over runs as "Power Surge" or "Normal"
 * based on the row average, reusing a single rowAverage() helper method.
 */
public class Problem_4 {

    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String label = (avg >= threshold) ? "Power Surge" : "Normal";

            result.append("Match ").append(i).append(": ").append(label);
            if (i != runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(runsPerOver, 8));
    }
}
