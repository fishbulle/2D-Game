package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class UI {

     GamePanel gp;
     Graphics2D g2;
     Font dogicaPixel, dogicaPixelBold;
     public boolean messageOn;
     public String message;
     int messageCounter = 0;
     public boolean gameOver;
     public String currentDialogue;
     public int commandNum = 0;

     public UI(GamePanel gp) {
         this.gp = gp;

         try {
             InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fonts/dogicapixel.ttf");
             dogicaPixel = Font.createFont(Font.TRUETYPE_FONT, inputStream);

             inputStream = getClass().getClassLoader().getResourceAsStream("fonts/dogicapixelbold.ttf");
             dogicaPixelBold = Font.createFont(Font.TRUETYPE_FONT, inputStream);
         } catch (FontFormatException | IOException e) {
             e.printStackTrace();
         }
     }

     public void showMessage(String text) {
         message = text;
         messageOn = true;
     }

     public void draw(Graphics2D g2) {

         this.g2 = g2;
         g2.setFont(dogicaPixel);
         g2.setColor(Color.WHITE);

         // TITLE STATE
         if (gp.gameState == gp.titleState) {
             drawTitleScreen();
         }
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

     public void drawTitleScreen() {
         Random random = new Random();
         int A = random.nextInt(255);
         int B = random.nextInt(255);
         int C = random.nextInt(255);

         g2.setColor(new Color(0, 0, 0));
         g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

         // Game title
         g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50F));
         String text = "Enchanted Forest";
         int x = getXForCenteredText(text);
         int y = gp.tileSize * 3;

         // SHADOW
         g2.setColor(Color.white);
         g2.drawString(text, x, y);
         // MAIN TEXT
         g2.setColor(new Color(A, B, C));
         g2.drawString(text, x+3, y+3);

         // PLAYER IMAGE
         x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2;
         y += gp.tileSize * 2;
         g2.drawImage(gp.player.downStill, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

         // MENU
         g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25F));
         g2.setColor(Color.white);

         text = "NEW GAME";
         x = getXForCenteredText(text);
         y += gp.tileSize * 4;
         g2.drawString(text, x, y);
         if (commandNum == 0) {
             g2.drawString(">", x - gp.tileSize, y);
         }

         g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25F));
         text = "LOAD GAME";
         x = getXForCenteredText(text);
         y += gp.tileSize;
         g2.drawString(text, x, y);
         if (commandNum == 1) {
             g2.drawString(">", x - gp.tileSize, y);
         }

         g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25F));
         text = "QUIT GAME";
         x = getXForCenteredText(text);
         y += gp.tileSize;
         g2.drawString(text, x, y);
         if (commandNum == 2) {
             g2.drawString(">", x - gp.tileSize, y);
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

         g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14F));
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
