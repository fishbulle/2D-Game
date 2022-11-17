package object;

import entity.Entity;
import main.GamePanel;

public class Heart extends Entity {

    public Heart(GamePanel gp) {

        super(gp);

        name = "Heart";
        image = setUp("objects/heartfull", gp.tileSize, gp.tileSize);
        image2 = setUp("objects/hearthalf", gp.tileSize, gp.tileSize);
        image3 = setUp("objects/heartempty", gp.tileSize, gp.tileSize);
    }
}
