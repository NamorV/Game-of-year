package rpg;

import java.util.Random;

public class Unit {
    private static final int STANDARD_HEALTH = 10;

    private String name;
    private int health;

    public Unit(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public Unit(String name) {
        this.name = name;
        this.health = STANDARD_HEALTH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Unit attack(Unit enemy) {
        Random random = new Random();
        int attackValue = random.nextInt(6) + 1;
        int currentHealth = enemy.getHealth() - attackValue;

        enemy.setHealth(currentHealth);
        return enemy;
    }
}
