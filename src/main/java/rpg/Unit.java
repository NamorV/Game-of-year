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
        if(isAlive()) {
            Random random = new Random();
            int attackValue = random.nextInt(6) + 1;
            int currentHealth = enemy.getHealth() - attackValue;

            System.out.println(name + " deal " + attackValue + " to " + enemy.getName());
            enemy.setHealth(currentHealth);
        }

        return enemy;
    }

    public boolean isAlive() {
        if(health < 1) {
            System.out.println(name + " is dead!");
            return false;
        }

        return true;
    }

    public void status() {
        System.out.println("Name: " + name + "   Health: " + health);
    }

    public Unit makeAction(int actionNumber, Unit enemy) {
        switch (actionNumber) {
            case 1:
                enemy = attack(enemy);
                break;
            default:
                System.out.println("Wrong action!");
        }

        return enemy;
    }
}
