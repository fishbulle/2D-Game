package object;

import entity.Entity;
import main.GamePanel;

public class Boots extends Entity {

    public Boots(GamePanel gp) {

        super(gp);

        name = "Boots";
        down1 = setUp("objects/boots");
    }
}
