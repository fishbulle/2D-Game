package entity;

import main.GamePanel;
import java.util.Random;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        type = type_npc;
        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
    }

    public void getImage() {

        up1 = setUp("npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setUp("npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setUp("npc/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setUp("npc/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setUp("npc/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setUp("npc/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setUp("npc/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setUp("npc/oldman_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogue[0] = "Hello stranger.";
        dialogue[1] = "I see you have stumbled upon my enchanted island. \nDo be aware of possible dangers ahead. \nI cannot seem to remember where the monsters dwell.";
        dialogue[2] = ". . .";
        dialogue[3] = "Did you happen to have a boat?";
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

    public void speak() {
        super.speak();
    }
}
