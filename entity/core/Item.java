package entity.core;

public class Item {
    protected String name;
    protected String description;
    protected int weight;
    protected int amount = 1;
    protected boolean isUsedInCombat;

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getWeight() { return weight; }
    public int amount() { return amount; }
    public boolean IsUsedInCombat() { return isUsedInCombat; }

    public Item(String name, String description, int weight, boolean isUsedInCombat) {
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.isUsedInCombat = isUsedInCombat;
    }

    public void use(){};
    public void use(Enemy enemy){};
    public void use(Player player){};

    public void AddAmount(){
        amount++;
    }
}
