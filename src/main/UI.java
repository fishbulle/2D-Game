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
     public boolean messageOn;
     public String message;
     int messageCounter = 0;
     public boolean gameOver;
     public String currentDialogue;

     public UI(GamePanel gp) {
         this.gp = gp;
         font1 = new Font("Arial", Font.BOLD, 30);
         font2 = new Font("Arial", Font.BOLD, 80);
     }

     public void showMessage(String text) {
         message = text;
         messageOn = true;
     }

     public void draw(Graphics2D g2) {

         this.g2 = g2;
         g2.setFont(font2);
         g2.setColor(Color.WHITE);

         // PLAY STATE
         if (gp.gameState == gp.playState) {
             // Do playState stuff
         }
         // PAUSE STATE
         if (gp.gameState == gp.pauseState) {
             drawPauseScreen();
         }
         // DIALOGUE STATE
         if (gp.gameState == gp.dialogueState) {
             drawDialogueScreen();
         }
     }

     public void drawPauseScreen() {
         String text = "GAME PAUSED";
         int x = getXForCenteredText(text);
         int y = gp.screenHeight / 2;

         g2.drawString(text, x, y);
     }

     public void drawDialogueScreen() {
         // Dialogue window
         int x = gp.tileSize * 2;
         int y = gp.tileSize / 2;
         int width = gp.screenWidth - (gp.tileSize * 4);
         int height = gp.tileSize * 4;
         drawWindow(x, y, width, height);

         g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
         x += gp.tileSize;
         y += gp.tileSize;

         for (String line : currentDialogue.split("\n")) {
             g2.drawString(line, x, y);
             y += 40;
         }
     }

     public void drawWindow(int x, int y, int width, int height) {
         Color c = new Color(0, 0, 0, 210); // last number is alpha value (adjusts opacity)
         g2.setColor(c);
         g2.fillRoundRect(x, y, width, height, 35, 35);

         c = new Color(255, 255, 255);
         g2.setColor(c);
         g2.setStroke(new BasicStroke(5));
         g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
     }

     public int getXForCenteredText(String text) {
         int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
         return (gp.screenWidth / 2) - (length / 2);
     }
}
