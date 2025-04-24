import java.util.Random;
import java.util.Scanner;

public class Game {
    static int health = 100;
    static int gold = 0;
    static int room = 1;
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🏰 Welcome to Jawa Dungeon!");

        while (health > 0) {
            if (health > 0) break;
            System.out.println("\n🔹 Room " + room);
            int event = random.nextInt(0,4);

            switch (event) {
                case 0 -> findMonster();
                case 1 -> findTreasure();
                case 2 -> findTrap();
                case 3 -> emptyRoom();
            }

            System.out.println("❤️ Health: " + health + " | 💰 Gold: " + gold);
            System.out.print("▶ Continue to next room? (y/n): ");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) break;

            room++;
        }

        System.out.println("\n💀 Game Over! You reached room " + room + " with " + gold + " gold.");
    }

    static void findMonster() {
        int damage = random.nextInt(10, 25);
        System.out.println("😈 A monster appears and hits you for " + damage + " damage!");
        health -= damage;
    }

    static void findTreasure() {
        int loot = random.nextInt(10, 50);
        System.out.println("💰 You found a treasure chest with " + loot + " gold!");
        gold += loot;
    }

    static void findTrap() {
        int damage = random.nextInt(5, 15);
        System.out.println("💀 You stepped on a trap and took " + damage + " damage!");
        health -= damage;
    }

    static void emptyRoom() {
        System.out.println("😶 The room is eerily empty...");
    }
}
