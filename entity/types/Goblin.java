package entity.types;

import entity.core.*;

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", 50, 10, 3, 25);
    }

    @Override
    public void useAbility(Player player) {
        System.out.println(name + " throws a dagger at the player!");
        player.takeDamage(attack + 3);
    }
}
