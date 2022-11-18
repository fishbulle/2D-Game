package object;

import entity.Entity;
import main.GamePanel;

public class Boots extends Entity {

    public Boots(GamePanel gp) {

        super(gp);

        name = "Pink Boots";
        down1 = setUp("objects/boots", gp.tileSize, gp.tileSize);
        description = "["+ name + "]\nA pair of magical boots.\nSpeed +2";
    }
}
