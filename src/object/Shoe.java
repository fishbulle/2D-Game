package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Shoe extends SuperObject {

    public Shoe() {
        name = "Shoe";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/shoe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
