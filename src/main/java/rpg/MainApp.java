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

            while(player.isAlive() && enemy.isAlive()) {
                enemy = player.attack(enemy);
                player = enemy.attack(player);
            }
        }
    }

}
