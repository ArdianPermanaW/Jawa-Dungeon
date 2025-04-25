package entity.types;

import entity.core.*;

public class Slime extends Enemy {
    public Slime() {
        super("Slime", 30, 5, 1, 10);
    }

    @Override
    public void useAbility(Player player) {
        System.out.println(name + " uses Mitosis! It heals itself.");
        heal(5);
    }
}
