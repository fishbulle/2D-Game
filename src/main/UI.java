package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

     GamePanel gp;
     Font font1;
     BufferedImage keyImg;
     public boolean messageOn;
     public String message;
     int messageCounter = 0;

     public UI(GamePanel gp) {
         this.gp = gp;
         font1 = new Font("Arial", Font.BOLD, 20);
         Key key = new Key();
         keyImg = key.image;
     }

     public void showMessage(String text) {
         message = text;
         messageOn = true;
     }

     public void draw(Graphics2D g2) {
         g2.setFont(font1);
         g2.setColor(Color.white);
         g2.drawImage(keyImg, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize / 2, null);
         g2.drawString("x " + gp.player.hasKey, 52, 45);

         // MESSAGE DISPLAY
         if (messageOn) {
             g2.setFont(g2.getFont().deriveFont(20F));
             g2.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
             messageCounter++;

             if (messageCounter > 120) {
                 messageCounter = 0;
                 messageOn = false;
             }
         }
     }
}
