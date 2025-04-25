package entity.types;
import entity.core.*;
import java.util.Random;

public class Slime extends Enemy {
    static Random random = new Random();
    int panicHealUse = 1;
    public Slime() {
        super("Slime", 30, 5, 1, 10);
    }

    @Override
    public void takeTurn(Player player) {
        if(hp < 15 && panicHealUse > 0){
            System.out.println(name + " panics and heals itself! ");
            heal(10);
            panicHealUse--;
            System.out.print("Then ");
        }
        int dice = random.nextInt(6) + 1;
        if(dice == 6){
            System.out.println(name + " uses Mitosis! It heals itself.");
            heal(5);
        }else{
            attack(player);
        }
    }
}
