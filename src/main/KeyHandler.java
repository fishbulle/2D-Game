package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean checkDrawTime;
    public boolean talk;

    public KeyHandler (GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // returns the number of the key that was pressed

        // PLAY STATE
        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }

            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }

            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }

            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.pauseState;
            }
            if (code == KeyEvent.VK_ENTER) {
                talk = true;
            }

            // DEBUG
            if (code == KeyEvent.VK_T) {
                checkDrawTime = !checkDrawTime;
            }
        }
        // PAUSE STATE
        else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_ESCAPE) {
                gp.gameState = gp.playState;
            }
        }
        // DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_SPACE) {
                gp.gameState = gp.playState;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}
