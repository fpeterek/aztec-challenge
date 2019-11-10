package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Spear extends GameEntity implements Renderable, Damaging {

    private static int spears = 0;
    public static void resetSpearCount() {
        spears = 0;
    }
    public static int spearCount() {
        return spears;
    }

    private Image sprite;

    public Spear(double x, double y, double width, double height, Image img) {
        super(x, y, width, height);
        affectedByGravity(false);
        sprite = img;
        ++spears;
    }


    @Override
    public void render(GraphicsContext gc) {
        if (getForces().x < 0) {
            gc.drawImage(sprite, 0, 0, width(), height(), x() + width(), y(), -width(), height());
        } else {
            gc.drawImage(sprite, 0, 0, width(), height(), x(), y(), width(), height());
        }
    }

    @Override
    public void onDelete() {
        --spears;
    }

}
