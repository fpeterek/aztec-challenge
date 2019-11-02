package AztecChallenge.GameEngine;

import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Player extends GameEntity implements Renderable {

    public Color color;

    public abstract void onUp();
    public abstract void onDown();
    public abstract void onLeft();
    public abstract void onRight();

    public abstract void onUpRelease();
    public abstract void onDownRelease();
    public abstract void onLeftRelease();
    public abstract void onRightRelease();

    public abstract void tick(double timeDelta);

    public Player(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(1, 0, 0, 1);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }

}
