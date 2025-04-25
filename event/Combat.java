package event;
import java.util.Random;
import java.util.Scanner;

import entity.core.*;

public class Combat {
    private Player player;
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public boolean NormalCombat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        System.out.println("A wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            
            printStatus();
            printOptions();

            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "1":
                    playerAttack();
                    break;
                case "2":
                    defend();
                    break;
                case "3":
                    flee();
                    return false;
                default:
                    System.out.println("Invalid move. Try again.");
            }

            if (enemy.isAlive()) {
                enemyTurn();
            }
        }

        if (player.isAlive()) {
            System.out.println("🎉 You defeated the " + enemy.getName() + "!");
            return true;
        } else {
            System.out.println("💀 You were defeated...");
            return false;
        }
    }

    private void printStatus() {
        System.out.println("\n=== Combat ===");
        System.out.println("Player HP: " + player.getHp());
        System.out.println(enemy.getName() + " HP: " + enemy.getHp());
    }

    private void printOptions() {
        System.out.println("\nYour move:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Flee");
        System.out.print("> ");
    }

    private void playerAttack() {
        int dmg = player.attack(enemy);
        System.out.println("You dealt " + dmg + " damage to the " + enemy.getName() + "!");
    }

    private void defend() {
        System.out.println("You brace for impact, reducing incoming damage.");
        player.setDefending(true);
    }

    private void flee() {
        System.out.println("You fled the battle.");
    }

    private void enemyTurn() {
        System.out.println(enemy.getName() + "'s turn!");

        // Optional: Add random chance to use ability
        if (Math.random() < 0.3) {
            enemy.useAbility(player);
        } else {
            int dmg = enemy.attack(player);
            System.out.println(enemy.getName() + " hits you for " + dmg + " damage!");
        }

        // Reset defend status after enemy turn
        player.setDefending(false);
    }

}
