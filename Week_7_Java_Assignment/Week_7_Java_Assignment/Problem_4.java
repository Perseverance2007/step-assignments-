/**
 * Problem 4 - The Traffic Light
 * The color is private and can only move forward through the fixed cycle
 * RED -> GREEN -> YELLOW -> RED via next(); there is no direct setter.
 */
class TrafficLight {
    private String color;
    private final String id;
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        int currentIndex = 0;
        for (int i = 0; i < CYCLE.length; i++) {
            if (CYCLE[i].equals(color)) {
                currentIndex = i;
                break;
            }
        }
        int nextIndex = (currentIndex + 1) % CYCLE.length;
        color = CYCLE[nextIndex];
        return color;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}

public class Problem_4 {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
    }
}
