package main;

import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new Key();
        gp.obj[0].worldX = 5 * gp.tileSize; // placement for object
        gp.obj[0].worldY = 26 * gp.tileSize; // placement for object

        gp.obj[1] = new Key();
        gp.obj[1].worldX = 14 * gp.tileSize;
        gp.obj[1].worldY = 3 * gp.tileSize;

        gp.obj[2] = new Key();
        gp.obj[2].worldX = 46 * gp.tileSize;
        gp.obj[2].worldY = 26 * gp.tileSize;

        gp.obj[3] = new Door();
        gp.obj[3].worldX = 10 * gp.tileSize;
        gp.obj[3].worldY = 10 * gp.tileSize;

        gp.obj[4] = new Door();
        gp.obj[4].worldX = 34 * gp.tileSize;
        gp.obj[4].worldY = 32 * gp.tileSize;

        gp.obj[5] = new Chest();
        gp.obj[5].worldX = 34 * gp.tileSize;
        gp.obj[5].worldY = 34 * gp.tileSize;

        gp.obj[6] = new Boots();
        gp.obj[6].worldX = 29 * gp.tileSize;
        gp.obj[6].worldY = 21 * gp.tileSize;

        gp.obj[7] = new Stone();
        gp.obj[7].worldX = 25 * gp.tileSize;
        gp.obj[7].worldY = 22 * gp.tileSize;
    }
}
