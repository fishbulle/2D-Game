package object;

import entity.Entity;
import main.GamePanel;

public class Chest extends Entity {

    public Chest(GamePanel gp) {

        super(gp);

        name = "Chest";
        down1 = setUp("objects/chest");
    }
}
