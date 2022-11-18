package object;

import entity.Entity;
import main.GamePanel;

public class BasicShield extends Entity {

    public BasicShield(GamePanel gp) {
        super(gp);

        name = "Basic Shield";
        down1 = setUp("objects/basicshield", gp.tileSize, gp.tileSize);
        defenseValue = 1;
    }
}