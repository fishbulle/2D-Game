package main;

import entity.MON_PurpleBlob;
import entity.NPC_OldMan;
import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
/*        gp.obj[0] = new Door(gp);
        gp.obj[0].worldX = gp.tileSize * 21;
        gp.obj[0].worldY = gp.tileSize * 22;*/
    }

    public void setNPC() {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;

    }

    public void setMonster() {
        gp.monster[0] = new MON_PurpleBlob(gp);
        gp.monster[0].worldX = gp.tileSize * 24;
        gp.monster[0].worldY = gp.tileSize * 35;

        gp.monster[1] = new MON_PurpleBlob(gp);
        gp.monster[1].worldX = gp.tileSize * 25;
        gp.monster[1].worldY = gp.tileSize * 37;
    }
}
