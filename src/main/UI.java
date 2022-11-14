package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

     GamePanel gp;
     Font font1;
     Font font2;
     BufferedImage keyImg;
     public boolean messageOn;
     public String message;
     int messageCounter = 0;
     public boolean gameOver;
     double playTime;
     DecimalFormat dFormat = new DecimalFormat("#0.00");

     public UI(GamePanel gp) {
         this.gp = gp;
         font1 = new Font("Arial", Font.BOLD, 30);
         font2 = new Font("Arial", Font.BOLD, 80);
         Key key = new Key(gp);
         keyImg = key.image;
     }

     public void showMessage(String text) {
         message = text;
         messageOn = true;
     }

     public void draw(Graphics2D g2) {

         if (gameOver) {
             String text;
             int textLength;
             int x;
             int y;

             g2.setFont(font1);
             g2.setColor(Color.white);
             text = "You found the treasure!";
             textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // returns the length of the sentence
             x = (gp.screenWidth / 2) - (textLength / 2);
             y = (gp.screenHeight / 2) - (gp.tileSize * 2);
             g2.drawString(text, x, y);

             text = "Total play time: " + dFormat.format(playTime) + " seconds.";
             textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // returns the length of the sentence
             x = (gp.screenWidth / 2) - (textLength / 2);
             y = (gp.screenHeight / 2) + (gp.tileSize * 4);
             g2.drawString(text, x, y);

             g2.setFont(font2);
             g2.setColor(Color.yellow);
             text = "Congratulations!";
             textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth(); // returns the length of the sentence
             x = (gp.screenWidth / 2) - (textLength / 2);
             y = (gp.screenHeight / 2) + (gp.tileSize * 3);
             g2.drawString(text, x, y);

             gp.gameThread = null;


         } else {
             g2.setFont(font1);
             g2.setColor(Color.white);
             g2.drawImage(keyImg, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize / 2, null);
             g2.drawString("x " + gp.player.hasKey, 52, 45);

             // TIME
             playTime += (double)1 / 60;
             g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 12, 45);

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
}
