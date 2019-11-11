package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Utils.Rectangle2d;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Pyramid extends Rectangle2d implements Renderable {
    private static final double WIDTH = 320;
    private static final double HEIGHT = 120;
    private Image sprite;

    public Pyramid(double winWidth, double pyramidBottom) {
        super(winWidth / 2 - WIDTH / 2, pyramidBottom - HEIGHT, WIDTH, HEIGHT);
        sprite = new Image("gauntlet_pyramid.png", WIDTH, HEIGHT, true, false);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(sprite, 0, 0, WIDTH, HEIGHT, x(), y(), WIDTH, HEIGHT);
    }
}


