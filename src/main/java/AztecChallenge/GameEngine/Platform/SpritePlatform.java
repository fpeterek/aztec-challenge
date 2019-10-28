package AztecChallenge.GameEngine.Platform;

import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SpritePlatform extends Platform implements Renderable {

    public Color color;

    public SpritePlatform(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(0, 0, 0, 1);
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }
}