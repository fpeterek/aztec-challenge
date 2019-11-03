package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Spear extends GameEntity implements Renderable, Damaging {

    public Color color;

    public Spear(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(0.5,0.3, 0.2, 1);
        affectedByGravity(false);
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }
}
