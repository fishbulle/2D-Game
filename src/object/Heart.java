package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Heart extends SuperObject {

    GamePanel gp;

    public Heart(GamePanel gp) {

        this.gp = gp;

        name = "Heart";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/heartfull.png"));
            image2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/hearthalf.png"));
            image3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/heartempty.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            image2 = uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            image3 = uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
