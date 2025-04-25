package entity.types;
import java.util.Random;
import entity.core.*;

public class Skeleton extends Enemy {
    static Random random = new Random();
    static int defBoneShieldDuration = 2;
    boolean boneShield = false;
    int boneShieldDuration = 0;
    public Skeleton() {
        super("Skeleton", 45, 12, 4, 20);
    }

    @Override
    public void takeTurn(Player player) {
        int dice = random.nextInt(4) + 1;
        if(dice == 4 && boneShield == false){
            System.out.println(name + " raises a bone shield! Defense temporarily increased.");
            boneShield = true;
            defense += 2;
            boneShieldDuration = defBoneShieldDuration;
        }else{
            attack(player);
            if(boneShieldDuration > 0){
                boneShieldDuration--;
            }else{
                boneShield = false;
            }
        }
    }
}
