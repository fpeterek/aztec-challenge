package AztecChallenge.Minigames.Stairs;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Boulder extends GameEntity implements Renderable, Damaging {

    public Color color;
    private Image sprite;

    public Boulder(double x, double y, double width, double height, Image sprite) {
        super(x, y, width, height);
        this.sprite = sprite;
        affectedByGravity(true);
    }

    @Override
    public void render(GraphicsContext gc) {
        int i = 0;
        gc.drawImage(sprite, i * width(), 0, width(), height(), x(), y(), width(), height());
    }

}

