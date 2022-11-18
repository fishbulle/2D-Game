package object;

import entity.Entity;
import main.GamePanel;

public class BasicShield extends Entity {

    public BasicShield(GamePanel gp) {
        super(gp);

        type = type_shield;
        name = "Basic Shield";
        down1 = setUp("objects/basicshield", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "["+ name + "]\nA simple, wooden shield.\nDefense: " + defenseValue;
    }
}
