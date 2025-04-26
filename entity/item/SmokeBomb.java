package entity.item;

import entity.core.Item;

public class SmokeBomb extends Item{
    public SmokeBomb() {
        super(
                "Smoke Bomb", 
                "Use in combat to guarantee escape. Always fail during boss and elite encounters, I mean they are special enemies for a reason", 
                3,
                true
            );
    }

    @Override
    public void use() {
        //TODO: make this work
    }
}
