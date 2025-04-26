package entity.item;

import entity.core.Item;

public class DisarmTool extends Item{
    public DisarmTool() {
        super(
            "Disarming Tools", 
            "Use this to safely disarm traps before triggering them", 
            1,
            false
        );
    }

    @Override
    public void use() {
        System.out.println("You carefully disarm the trap using the Disarm Kit");
        //TODO: Trigger event logic to nullify or bypass trap
    }
}
