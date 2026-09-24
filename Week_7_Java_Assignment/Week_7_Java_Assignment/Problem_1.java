/**
 * Problem 1 - The Health Bar
 * Health is private and can only change through takeDamage()/heal(), which
 * clamp the result between 0 and the final maxHealth.
 */
class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        int newHealth = health - amount;
        if (newHealth < 0) {
            newHealth = 0;
        }
        health = newHealth;
    }

    public void heal(int amount) {
        int newHealth = health + amount;
        if (newHealth > maxHealth) {
            newHealth = maxHealth;
        }
        health = newHealth;
    }

    public int getHealth() {
        return health;
    }
}

public class Problem_1 {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getHealth());

        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getHealth());

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth());
    }
}
