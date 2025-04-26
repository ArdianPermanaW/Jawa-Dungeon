package entity.enemy;
import java.util.Random;
import entity.core.*;

public class Goblin extends Enemy {
    static Random random = new Random();
    static double critMultiplier = 1.5;
    public Goblin() {
        super("Goblin", 50, 10, 3, 25);
    }

    @Override
    public void takeTurn(Player player) {
        int dice = random.nextInt(6) + 1;
        if (dice == 6){
            System.out.println(name + " scores a critical hit at the player!");
            attack(player,(int)(getAttack() * critMultiplier));
        }else{
            attack(player);
        }
    }
}
