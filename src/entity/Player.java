package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
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
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.up1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.up2.png"));
            upStill = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.upstill.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.down1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.down2.png"));
            downStill = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.downstill.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.left1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.left2.png"));
            leftStill = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.leftstill.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.right1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.right2.png"));
            rightStill = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/sprite.rightstill.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update () {

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
           // gp.obj[i] = null; // deletes the object player touches
            String objectName = gp.obj[i].name;

            switch (objectName) {
                case "Key":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i] = null;
                    System.out.println("You found a key! You now have " + hasKey + " keys.");
                    break;
                case "Door":
                    gp.playSE(3);
                    if (hasKey > 0) {
                        gp.obj[i] = null;
                        hasKey--;
                        System.out.println("Key used. You now have " + hasKey + " keys left.");
                    } else {
                        System.out.println("You don't have a key to open this door.");
                    }
                    break;
                case "Boots":
                    gp.playSE(2);
                    System.out.println("You found a pair of shiny, pink boots! Maybe they'll be useful somehow...");
                    speed += 2;
                    gp.obj[i] = null;
                    break;
                case "Stone":
                    System.out.println("Ouch, your big toe hurt as fuck from hitting that rock.");
                    break;
            }
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

        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

    }

}
