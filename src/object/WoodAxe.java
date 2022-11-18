package object;

import entity.Entity;
import main.GamePanel;

public class WoodAxe extends Entity {
    public WoodAxe(GamePanel gp) {
        super(gp);

        type = type_axe;
        name = "Wooden Axe";
        down1 = setUp("objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 0;
        attackArea.width = 20;
        attackArea.height = 20;
        description = "["+ name + "]\nA rusty axe. Can probably \nstill cut down trees.\nAttack: " + attackValue;
    }
}
