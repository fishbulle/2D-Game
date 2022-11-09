package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // SCREEN SETTINGS
    final int originalTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 16x3 = 48 -> 48x48 tile
    public final int maxScreenCol = 18; // horizontally
    public final int maxScreenRow = 14; // vertically
    public final int screenWidth = tileSize * maxScreenCol;  // 864 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 672 pixels
    double FPS = 60; // FPS = frames per second

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

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
        player.update();  // calling update in Player class
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileM.draw(g2);     // calling draw in TileManager class (before player or else tiles will hide player)
        player.draw(g2); // calling draw in Player class
        g2.dispose();
    }
}
