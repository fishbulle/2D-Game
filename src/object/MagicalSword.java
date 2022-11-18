package object;

import entity.Entity;
import main.GamePanel;

public class MagicalSword extends Entity {
    public MagicalSword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = "Magical Sword";
        down1 = setUp("objects/magicalsword", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 40;
        attackArea.height = 40;
        description = "["+ name + "]\nA sharp-looking, golden\nsword.\nAttack: " + attackValue;
    }
}
