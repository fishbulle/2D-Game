package object;

import entity.Entity;
import main.GamePanel;

public class LeatherBoots extends Entity {
    public LeatherBoots(GamePanel gp) {
        super(gp);

        type = type_boots;
        name = "Leather Boots";
        down1 = setUp("objects/leatherboots", gp.tileSize, gp.tileSize);
        speedValue = 4;
        description = "["+ name + "]\nA pair of beaten up \nleather boots.";
    }
}
