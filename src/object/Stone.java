package object;

import entity.Entity;
import main.GamePanel;

public class Stone extends Entity {

    public Stone(GamePanel gp) {

        super(gp);

        name = "Stone";
        down1 = setUp("objects/stone");
        collision = true;
    }
}
