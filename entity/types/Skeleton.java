package entity.types;

import entity.core.*;

public class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 45, 12, 0, 20);
    }

    @Override
    public void useAbility(Player player) {
        System.out.println(name + " raises a bone shield! Defense temporarily increased.");
        defense += 2;
    }
}
