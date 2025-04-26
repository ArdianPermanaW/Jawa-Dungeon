package entity.item;

import entity.core.Item;
import entity.core.Player;

public class HealingPotion extends Item{
    private static final int healAmount = 20;

    public HealingPotion() {
        super(
            "Healing Potion", 
            "Heals the player for " + healAmount + " HP", 
            2,
            true
            );
    }

    @Override
    public void use(Player player) {
        player.heal(healAmount);
    }
}
