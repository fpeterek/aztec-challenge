package AztecChallenge.Minigames.Stairs;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Boulder extends GameEntity implements Renderable, Damaging {

    private static final double spriteUpdatePeriod = 0.3;

    public Color color;
    private Image sprite;
    private double spriteCounter = 0;

    public Boulder(double x, double y, double width, double height, Image sprite) {
        super(x, y, width, height);
        this.sprite = sprite;
        affectedByGravity(true);
    }

    @Override
    public void render(GraphicsContext gc) {
        int i = (int)(spriteCounter / spriteUpdatePeriod);
        gc.drawImage(sprite, i * width(), 0, width(), height(), x(), y(), width(), height());
    }

    @Override
    public void tick(double timedelta) {
        spriteCounter += timedelta;
        spriteCounter %= spriteUpdatePeriod * 4;
    }

}

