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

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setUp("monsters/blobpurple");
        up2 = setUp("monsters/blobpurple2");
        down1 = setUp("monsters/blobpurple");
        down2 = setUp("monsters/blobpurple2");
        left1 = setUp("monsters/blobpurple");
        left2 = setUp("monsters/blobpurple2");
        right1 = setUp("monsters/blobpurple");
        right2 = setUp("monsters/blobpurple2");
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
}
