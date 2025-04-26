import java.util.Random;
import java.util.Scanner;

import entity.core.*;
import event.*;

public class Game {
    static int gold = 0;
    static int room = 1;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String[] enemyTypes = {"Slime","Skeleton","Goblin"}; 
    
    
    public static void main(String[] args) {
        System.out.println("🏰 Welcome to Jawa Dungeon!");
        
        Player player = new Player();

        while (player.isAlive()) {
            System.out.println("\n🔹 Room " + room);
            int event = random.nextInt(0,4);

            switch (event) {
                case 0 -> findMonster(player);
                case 1 -> findTreasure();
                case 2 -> findTrap(player);
                case 3 -> emptyRoom();
            }

            System.out.println("❤️ Health: " + player.getHp() + " | 💰 Gold: " + gold);
            System.out.print("▶ Continue to next room (Press any key): ");
            scanner.nextLine();

            room++;
        }

        System.out.println("\n💀 Game Over! You reached room " + room + " with " + gold + " gold.");
    }

    static void findMonster(Player player) {
        Combat combat = new Combat();
        Enemy enemy = EnemyFactory.create(enemyTypes[random.nextInt(0,2)]);
        boolean won = combat.NormalCombat(player,enemy);

        if (won) {
            System.out.println("✨ You continue your journey...");
        }
    }

    static void findTreasure() {
        int loot = random.nextInt(10, 50);
        System.out.println("💰 You found a treasure chest with " + loot + " gold!");
        gold += loot;
    }

    static void findTrap(Player player) {
        int damage = random.nextInt(5, 15);
        System.out.println("💀 You stepped on a trap and took " + damage + " damage!");
        player.takeDamage(damage);
    }

    static void emptyRoom() {
        System.out.println("😶 The room is eerily empty...");
    }
}
