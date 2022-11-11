package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Stone extends SuperObject {

    public Stone() {
        name = "Stone";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/stone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
