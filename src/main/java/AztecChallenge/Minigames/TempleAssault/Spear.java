package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
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

    public Color color;

    public Spear(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(0.5,0.3, 0.2, 1);
        affectedByGravity(false);
        ++spears;
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }

    @Override
    public void onDelete() {
        --spears;
    }

}
