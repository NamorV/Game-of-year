package rpg;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the labyrinth!");
        System.out.print("Please, type your characters name: ");
        String name = scanner.nextLine();

        Unit player = new Unit(name);
        Unit enemy = new Unit("Scorpion");

        System.out.println("You are attacked by " + enemy.getName());

        while(true) {
            String line = scanner.nextLine();

            if(line.equals("q")) {
                System.exit(0);
            }

            combat(player, enemy);
        }
    }

    public static void combat(Unit player, Unit enemy) {
        Scanner scanner = new Scanner(System.in);
        player.listOfActions();

        int actionNumber = Integer.parseInt(scanner.nextLine());

        if(player.isAlive() && enemy.isAlive()) {
            enemy = player.makeAction(actionNumber, enemy);
            player = enemy.attack(player);
        }

        if(!player.isAlive()) {
            System.out.println(enemy.getName() + " is victorious! You are dead!");
        }

        if(!enemy.isAlive()) {
            System.out.println(player.getName() + " is victorious!");
        }
    }

}
