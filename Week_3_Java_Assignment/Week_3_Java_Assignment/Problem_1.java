import java.util.*;

/*
 * Problem 1: The Exam Hall Seat Duplication Checker
 * Compares every seat number against every other seat number
 * (nested loops, no Collections class) to find duplicates.
 */
public class Problem_1 {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.println("Input: " + Arrays.toString(seats1));
        checkDuplicateSeats(seats1);

        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.println("Input: " + Arrays.toString(seats2));
        checkDuplicateSeats(seats2);
    }
}
