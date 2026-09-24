/**
 * Problem 4 - Exam Hall Ticket Reference Management (M4)
 * Demonstrates that a second variable pointing at the same object is a
 * reference to the SAME object (==), while a new object with identical
 * field values is a different object (not ==).
 */
class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class Problem_4 {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);

        // copy points at the SAME object as priya, not a new one
        HallTicket copy = priya;
        copy.seatNumber = 45;

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}
