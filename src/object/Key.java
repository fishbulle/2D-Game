package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends SuperObject {

    GamePanel gp;
    public Key(GamePanel gp) {

        this.gp = gp;

        name = "Key";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
