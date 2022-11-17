package entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);
        solidArea = new Rectangle(14, 32, 20, 16);  // adjust for managing sprite collision
        solidAreaDefaultX = 14;
        solidAreaDefaultY = 32;
        attackArea.width = 36;
        attackArea.height = 36;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImg();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;   // player's starting position on the world map
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";

        // PLAYER STATUS
        maxLife = 6;
        life = maxLife;
    }

    public void getPlayerImage() {

        up1 = setUp("player/sprite.up1", gp.tileSize, gp.tileSize);
        up2 = setUp("player/sprite.up2", gp.tileSize, gp.tileSize);
        upStill = setUp("player/sprite.upstill", gp.tileSize, gp.tileSize);
        down1 = setUp("player/sprite.down1", gp.tileSize, gp.tileSize);
        down2 = setUp("player/sprite.down2", gp.tileSize, gp.tileSize);
        downStill = setUp("player/sprite.downstill", gp.tileSize, gp.tileSize);
        left1 = setUp("player/sprite.left1", gp.tileSize, gp.tileSize);
        left2 = setUp("player/sprite.left2", gp.tileSize, gp.tileSize);
        leftStill = setUp("player/sprite.leftstill", gp.tileSize, gp.tileSize);
        right1 = setUp("player/sprite.right1", gp.tileSize, gp.tileSize);
        right2 = setUp("player/sprite.right2", gp.tileSize, gp.tileSize);
        rightStill = setUp("player/sprite.rightstill", gp.tileSize, gp.tileSize);
    }

    public void getPlayerAttackImg() {

        attackUp1 = setUp("player/attackup1", gp.tileSize, gp.tileSize * 2);
        attackUp2 = setUp("player/attackup2", gp.tileSize, gp.tileSize * 2);
        attackDown1 = setUp("player/attackdown1", gp.tileSize, gp.tileSize * 2);
        attackDown2 = setUp("player/attackdown2", gp.tileSize, gp.tileSize * 2);
        attackLeft1 = setUp("player/attackleft1", gp.tileSize * 2, gp.tileSize);
        attackLeft2 = setUp("player/attackleft2", gp.tileSize * 2, gp.tileSize);
        attackRight1 = setUp("player/attackright1", gp.tileSize * 2, gp.tileSize);
        attackRight2 = setUp("player/attackright2", gp.tileSize * 2, gp.tileSize);
    }

    public void update() {

        if (attacking) {

            attacking();

        } else if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.enterPressed) {

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

            // CHECK MONSTER COLLISION
            int monsterIndex = gp.collisionCheck.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);

            // CHECK EVENT COLLISION
            gp.eHandler.checkEvent();

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if (!collisionOn && !keyH.enterPressed) {
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            gp.keyH.enterPressed = false;

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

        // Needs to be outside of if statement! ^
        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void attacking() {
        spriteCounter++;
        if (spriteCounter <= 5) {
            spriteNum = 1;
        }

        if (spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;

            // Save the current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            // Adjust player's worldX/Y for the attackArea
            switch (direction) {
                case "up" -> worldY -= attackArea.height;
                case "down" -> worldY += attackArea.height;
                case "left" -> worldX -= attackArea.width;
                case "right" -> worldX += attackArea.width;
            }
            // Attack area becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            // Check monster collision with the updated worldX, worldY and solidArea
            int monsterIndex = gp.collisionCheck.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            // After checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }

        if (spriteCounter > 25) {
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {

        }
    }

    public void interactNPC(int i) {
        if (gp.keyH.enterPressed) {
            if (i != 999) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            } else {
                attacking = true;
            }
        }
    }

    public void contactMonster(int i) {
        if (i != 999) {
            if (!invincible) {
                life -= 1;
                invincible = true;
            }
        }
    }

    public void damageMonster(int i) {
        if (i != 999) {
            if (!gp.monster[i].invincible) {
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;

                if (gp.monster[i].life < 0) {
                    gp.monster[i] = null;
                }
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch (direction) {
            case "up" -> {
                if (!attacking) {
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
                if (attacking) {
                    tempScreenY = screenY - gp.tileSize;
                    if (spriteNum == 1)
                        image = attackUp1;
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                }
            }
            case "down" -> {
                if (!attacking) {
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
                if (attacking) {
                    if (spriteNum == 1)
                        image = attackDown1;
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                }
            }
            case "left" -> {
                if (!attacking) {
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
                if (attacking) {
                    tempScreenX = screenX - gp.tileSize;
                    if (spriteNum == 1)
                        image = attackLeft1;
                    if (spriteNum == 2) {
                        image = attackLeft2;
                    }
                }
            }
            case "right" -> {
                if (!attacking) {
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
                if (attacking) {
                    if (spriteNum == 1)
                        image = attackRight1;
                    if (spriteNum == 2) {
                        image = attackRight2;
                    }
                }
            }
        }

        if (invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f)); // sets opacity level
        }

        g2.drawImage(image, tempScreenX, tempScreenY,null);
        // Reset alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    }

}
