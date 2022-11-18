package object;

import entity.Entity;
import main.GamePanel;

public class BasicSword extends Entity {

    public BasicSword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = "Basic Sword";
        down1 = setUp("objects/basicsword", gp.tileSize, gp.tileSize);
        attackValue = 1;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "["+ name + "]\nAn old, rusty sword.\nAttack: " + attackValue;
    }
}
