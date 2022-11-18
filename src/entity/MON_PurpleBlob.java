package entity;

import main.GamePanel;

import java.util.Random;

public class MON_PurpleBlob extends Entity {

    public MON_PurpleBlob(GamePanel gp) {
        super(gp);

        type = 2;
        name = "Purple Blob";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        attack = 4;
        defense = 0;
        exp = 1;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setUp("monsters/blobpurple", gp.tileSize, gp.tileSize);
        up2 = setUp("monsters/blobpurple2", gp.tileSize, gp.tileSize);
        down1 = setUp("monsters/blobpurple", gp.tileSize, gp.tileSize);
        down2 = setUp("monsters/blobpurple2", gp.tileSize, gp.tileSize);
        left1 = setUp("monsters/blobpurple", gp.tileSize, gp.tileSize);
        left2 = setUp("monsters/blobpurple2", gp.tileSize, gp.tileSize);
        right1 = setUp("monsters/blobpurple", gp.tileSize, gp.tileSize);
        right2 = setUp("monsters/blobpurple2", gp.tileSize, gp.tileSize);
    }

    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(101);

            if (i <= 25) {
                direction = "up";
            }

            if (i > 25 && i <= 50) {
                direction = "down";
            }

            if (i > 50 && i <= 75) {
                direction = "left";
            }

            if (i > 75) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void damageReaction() {
        actionLockCounter = 0;
        direction = gp.player.direction;
    }
}
