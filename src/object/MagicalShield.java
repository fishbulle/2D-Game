package object;

import entity.Entity;
import main.GamePanel;

public class MagicalShield extends Entity {
    public MagicalShield(GamePanel gp) {
        super(gp);

        type = type_shield;
        name = "Magical Shield";
        down1 = setUp("objects/magicalshield", gp.tileSize, gp.tileSize);
        defenseValue = 2;
        description = "["+ name + "]\nA beautiful shield.\nDefense: " + defenseValue;
    }
}
