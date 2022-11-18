package object;

import entity.Entity;
import main.GamePanel;

public class PinkBoots extends Entity {

    public PinkBoots(GamePanel gp) {

        super(gp);

        type = type_boots;
        name = "Pink Boots";
        speedValue = 6;
        defenseValue = 2;
        down1 = setUp("objects/pinkboots", gp.tileSize, gp.tileSize);
        description = "["+ name + "]\nA pair of magical boots.\nSpeed increased by 2.\nDefense: " + defenseValue;
    }
}
