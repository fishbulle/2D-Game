package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;
import object.Boots;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        solidArea = new Rectangle(14, 32, 20, 12);  // adjust for managing sprite collision
        solidAreaDefaultX = 14;
        solidAreaDefaultY = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;   // player's starting position on the world map
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {

        up1 = setUp("player/sprite.up1");
        up2 = setUp("player/sprite.up2");
        upStill = setUp("player/sprite.upstill");
        down1 = setUp("player/sprite.down1");
        down2 = setUp("player/sprite.down2");
        downStill = setUp("player/sprite.downstill");
        left1 = setUp("player/sprite.left1");
        left2 = setUp("player/sprite.left2");
        leftStill = setUp("player/sprite.leftstill");
        right1 = setUp("player/sprite.right1");
        right2 = setUp("player/sprite.right2");
        rightStill = setUp("player/sprite.rightstill");
    }

    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }

            // CHECK FOR COLLISION WITH SOLID TILE
            collisionOn = false;
            gp.collisionCheck.checkTile(this); // "this" means this player class as entity

            // CHECK FOR COLLISION WITH OBJECT
            int objectIndex = gp.collisionCheck.checkObject(this, true);
            pickUpObject(objectIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.collisionCheck.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn) {
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;      // skipping 3 because that's the "resting" image
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;      // skipping 3 because that's the "resting" image
                }
                else if (spriteNum == 3) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        else {
            spriteNum = 3;  // resting image
        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    public void interactNPC(int i) {
        if (i != 999) {
            System.out.println("Get out of my way!");
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = upStill;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = downStill;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = leftStill;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = rightStill;
                }
            }
        }

        g2.drawImage(image, screenX, screenY,null);

    }

}
