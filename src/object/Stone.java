package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Stone extends SuperObject {

    GamePanel gp;

    public Stone(GamePanel gp) {

        this.gp = gp;

        name = "Stone";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/stone.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
