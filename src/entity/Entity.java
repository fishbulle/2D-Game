package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

// Stores variables that will be used in player, monster and NPC classes
public class Entity {

    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, upStill, down1, down2, downStill, left1, left2, leftStill, right1, right2, rightStill,
    downBoots;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

}
