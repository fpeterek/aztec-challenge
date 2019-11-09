package AztecChallenge.Minigames.Stairs;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Boulder extends GameEntity implements Renderable, Damaging {

    public Color color;

    public Boulder(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(0.5,0.3, 0.2, 1);
        affectedByGravity(true);
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }

}

