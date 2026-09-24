import java.util.Arrays;

/**
 * Problem 1 - Fantasy Team Score Multiplier
 * Applies a 2x multiplier to the captain's score and a 1.5x multiplier
 * to the vice-captain's score, directly on the caller's original array.
 */
public class Problem_1 {

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * 2;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }
}
