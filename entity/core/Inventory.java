package entity.core;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>(); 
    protected int inventorySpace;
    private int currentWeight;

    public Inventory(int inventorySpace){
        this.inventorySpace = inventorySpace;
        this.currentWeight = 0; //no item on new inv create
    }

    public void addItem(Item item) {
        if(inventorySpace < currentWeight + item.getWeight()){
            System.out.println("Inventory too full cannot add item");
            return;
        }
        if (items.contains(item)) {
            item.AddAmount();
        }else{
            addItem(item);
        }
        currentWeight += item.getWeight();
    }
}
