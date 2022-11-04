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

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);  // can improve the game's rendering performance
    }

    public void startGameThread() {
        gameThread = new Thread(this);  // this = GamePanel
        gameThread.start();  // calls run method
    }

    @Override
    public void run() {
        // GAME LOOP
        while(gameThread != null) {
            // 1 UPDATE: update information such as character positions
            update();
            // 2 DRAW: draw the screen with the updated information
            repaint(); // calling paintComponent method
        }
    }

    public void update() {}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}
