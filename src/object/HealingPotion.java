package object;

import entity.Entity;
import main.GamePanel;

public class HealingPotion extends Entity {

    GamePanel gp;
    int value = 5;

    public HealingPotion(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_consumable;
        name = "Healing Potion";
        down1 = setUp("objects/potion", gp.tileSize, gp.tileSize);
        description = "[Healing Potion]\nHeals your life by " + value + ".";
    }

    public void use(Entity entity) {
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name + "!\n"
                + "Your life has been recovered by " + value + ".";
        entity.life += value;
        if (gp.player.life > gp.player.maxLife) {
            gp.player.life = gp.player.maxLife;
        }
        gp.playSE(2);
    }
}
