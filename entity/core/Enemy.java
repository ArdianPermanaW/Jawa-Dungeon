package entity.core;

public abstract class Enemy {
    protected String name;
    protected int maxHp;
    protected int hp;
    protected int attack;
    protected int defense;
    protected int expDrop;

    public Enemy(String name, int hp, int attack, int defense, int expDrop) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.expDrop = expDrop;
    }
    // --- Getters & Setters ---
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getExpDrop() { return expDrop; }

    public abstract void takeTurn(Player player);

    //basic attack
    public int attack(Player player) {
        int damage = Math.max(0, attack - player.getDefense());
        player.takeDamage(damage);
        return damage;
    }

    // Overloaded attack method with custom damage
    public int attack(Player player, int damage) {
        int finalDamage = Math.max(0, damage - player.getDefense());
        player.takeDamage(finalDamage);
        return finalDamage;
    }

    public void takeDamage(int dmg) {
        int actualDamage = Math.max(0, dmg - defense);
        hp -= actualDamage;
        System.out.println(name + " takes " + actualDamage + " damage! (HP: " + hp + ")");
    }

    public boolean isAlive() {
        return hp > 0;
    }

    protected void heal(int amount) {
        hp = Math.min(hp + amount, maxHp);
        System.out.println(name + " heals for " + amount + "! (HP: " + hp + ")");
    }
}