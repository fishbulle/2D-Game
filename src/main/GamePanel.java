package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 16x3 = 48 -> 48x48 tile
    final int maxScreenCol = 18; // horizontally
    final int maxScreenRow = 14; // vertically
    final int screenWidth = tileSize * maxScreenCol;  // 864 pixels
    final int screenHeight = tileSize * maxScreenRow; // 672 pixels
    double FPS = 60; // FPS = frames per second

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    // PLAYER'S DEFAULT POSITION
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);  // can improve the game's rendering performance
        this.addKeyListener(keyH);  // for the game to recognize the key input
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);  // this = GamePanel
        gameThread.start();  // calls run method
    }

    @Override
    public void run() {
        // GAME LOOP
        double drawInterval = 1000000000 / FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
            // 1 UPDATE: update information such as character positions
            update();
            // 2 DRAW: draw the screen with the updated information
            repaint(); // calling paintComponent method
                delta--;
            }
        }
    }

    public void update() {

        if (keyH.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
