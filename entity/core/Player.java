package entity.core;

public class Player {
    private int maxHp;
    private int hp;
    private int attack;
    private int defense;
    private int level;
    private int exp;
    private boolean isDefending;
    private int inventorySpace;

    private Inventory inventory;

    public Player() {
        this.level = 1;
        this.exp = 0;
        this.maxHp = 100;
        this.hp = maxHp;
        this.attack = 15;
        this.defense = 5;
        this.inventorySpace = 10;

        this.inventory = new Inventory(this.inventorySpace);
    }

    // --- Getters & Setters ---
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }

    public int attack(Enemy enemy) {
        int damage = Math.max(0, attack - enemy.getDefense());
        enemy.takeDamage(damage);
        return damage;
    }

    public void takeDamage(int dmg) {
        int actualDamage = Math.max(0, dmg - defense);
        if(isDefending) actualDamage /= 2;
        hp -= actualDamage;
        System.out.println("Player takes " + actualDamage + " damage! (HP: " + hp + ")");
    }

    public void setDefending(boolean defend) {
        isDefending = defend;
    }
    
    public void heal(int amount) {
        hp = Math.min(maxHp, hp + amount);
        System.out.println("Player heals " + amount + " HP! (HP: " + hp + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void gainExp(int amount) {
        exp += amount;
        System.out.println("Player gains " + amount + " EXP!");

        if (exp >= 100) {
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        exp = 0;
        maxHp += 20;
        hp = maxHp;
        attack += 5;
        defense += 3;
        System.out.println("Player leveled up! Now at level " + level + "!");
    }

}
