package object;

import entity.Entity;
import main.GamePanel;

public class Heart extends Entity {

    public Heart(GamePanel gp) {

        super(gp);

        name = "Heart";
        image = setUp("objects/heartfull");
        image2 = setUp("objects/hearthalf");
        image3 = setUp("objects/heartempty");
    }
}
