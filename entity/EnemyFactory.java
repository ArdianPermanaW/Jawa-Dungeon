package entity;

import entity.core.*;
import entity.types.*;

public class EnemyFactory {
    public static Enemy create(String type) {
        switch (type.toLowerCase()) {
            case "skeleton": return new Skeleton();
            case "goblin": return new Goblin();
            case "Slime": return new Slime();
            default: return new Slime();
        }
    }
}
