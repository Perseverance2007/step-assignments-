import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 5 - Fantasy League Auto-Draft Ranking Engine
 *
 * Draft rule: a player qualifies if EITHER
 *   - they clear the experience-only bar (matchesPlayed >= 10), regardless of fitness, OR
 *   - they clear the combined bar (matchesPlayed >= 5 AND not injured).
 *
 * Ranking rule: draftable players are ranked by fantasy points (battingAverage)
 * in descending order, using Player's own Comparable implementation with Arrays.sort().
 */
class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experience-only rule for established players
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined matches-and-fitness rule for newer players
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        // Descending order by fantasy points (battingAverage)
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class Problem_5 {

    static String draftAndRank(Player[] players) {
        List<Player> draftablePlayers = new ArrayList<>();

        for (Player p : players) {
            boolean qualifies = Player.isDraftable(p.matchesPlayed)
                    || Player.isDraftable(p.matchesPlayed, p.injured);
            if (qualifies) {
                draftablePlayers.add(p);
            }
        }

        Player[] draftableArray = draftablePlayers.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            result.append(i + 1).append(". ").append(draftableArray[i].name);
            if (i != draftableArray.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
