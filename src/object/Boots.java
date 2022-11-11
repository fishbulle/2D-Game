package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Boots extends SuperObject {

    public Boots() {
        name = "Boots";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/boots.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
