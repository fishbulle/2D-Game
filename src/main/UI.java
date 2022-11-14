package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

     GamePanel gp;
     Graphics2D g2;
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
//       Key key = new Key(gp);
//       keyImg = key.image;
     }

     public void showMessage(String text) {
         message = text;
         messageOn = true;
     }

     public void draw(Graphics2D g2) {

         this.g2 = g2;
         g2.setFont(font2);
         g2.setColor(Color.WHITE);

         if (gp.gameState == gp.playState) {
             // Do playState stuff
         }

         if (gp.gameState == gp.pauseState) {
             drawPauseScreen();
         }
     }

     public void drawPauseScreen() {
         String text = "GAME PAUSED";
         int x = getXforCenteredText(text);
         int y = gp.screenHeight / 2;

         g2.drawString(text, x, y);
     }

     public int getXforCenteredText(String text) {
         int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
         return (gp.screenWidth / 2) - (length / 2);
     }
}
