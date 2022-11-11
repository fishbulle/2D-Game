package main;

import object.Chest;
import object.Door;
import object.Key;
import object.Shoe;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 5 * gp.tileSize; // placement for object
        gp.obj[0].worldY = 26 * gp.tileSize; // placement for object

        gp.obj[1] = new Chest();
        gp.obj[1].worldX = 34 * gp.tileSize;
        gp.obj[1].worldY = 34 * gp.tileSize;

        gp.obj[2] = new Door();
        gp.obj[2].worldX = 34 * gp.tileSize;
        gp.obj[2].worldY = 32 * gp.tileSize;

        gp.obj[3] = new Shoe();
        gp.obj[3].worldX = 40 * gp.tileSize;
        gp.obj[3].worldY = 15 * gp.tileSize;
    }
}
