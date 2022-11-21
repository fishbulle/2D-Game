package main;

import entity.MON_PurpleBlob;
import entity.NPC_OldMan;
import object.*;

public class AssetSetter {

    GamePanel gp;
    int i = 0;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[i] = new Key(gp);
        gp.obj[i].worldX = gp.tileSize * 21;
        gp.obj[i].worldY = gp.tileSize * 22;
        i++;

        gp.obj[i] = new HealingPotion(gp);
        gp.obj[i].worldX = gp.tileSize * 20;
        gp.obj[i].worldY = gp.tileSize * 20;
        i++;

        gp.obj[i] = new MagicalShield(gp);
        gp.obj[i].worldX = gp.tileSize * 40;
        gp.obj[i].worldY = gp.tileSize * 10;
        i++;

        gp.obj[i] = new MagicalSword(gp);
        gp.obj[i].worldX = gp.tileSize * 10;
        gp.obj[i].worldY = gp.tileSize * 18;
        i++;

        gp.obj[i] = new WoodAxe(gp);
        gp.obj[i].worldX = gp.tileSize * 22;
        gp.obj[i].worldY = gp.tileSize * 25;
    }

    public void setNPC() {
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize * 21;
        gp.npc[0].worldY = gp.tileSize * 21;

    }

    public void setMonster() {
        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 24;
        gp.monster[i].worldY = gp.tileSize * 35;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 25;
        gp.monster[i].worldY = gp.tileSize * 37;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 23;
        gp.monster[i].worldY = gp.tileSize * 36;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 25;
        gp.monster[i].worldY = gp.tileSize * 38;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 24;
        gp.monster[i].worldY = gp.tileSize * 34;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 35;
        gp.monster[i].worldY = gp.tileSize * 34;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 36;
        gp.monster[i].worldY = gp.tileSize * 34;
        i++;

        gp.monster[i] = new MON_PurpleBlob(gp);
        gp.monster[i].worldX = gp.tileSize * 37;
        gp.monster[i].worldY = gp.tileSize * 34;

    }
}
