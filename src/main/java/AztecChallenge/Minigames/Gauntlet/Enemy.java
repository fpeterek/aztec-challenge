package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Enemy extends GameEntity implements Renderable {

    private static int spriteWidth = 24;
    private static int spriteHeight = 30;
    private static int spriteMod = 10;

    private Image sprite;

    public Enemy(double x, double y, double width, double height, Image img) {
        super(x, y, width, height);
        sprite = img;
        affectedByGravity(false);
    }


    @Override
    public void render(GraphicsContext gc) {
        if (getForces().x < 0) {
            gc.drawImage(sprite, 0, 0, spriteWidth*spriteMod, spriteHeight*spriteMod, x(), y(), width(), height());

        } else {
            gc.drawImage(sprite, 0, 0, spriteWidth*spriteMod, spriteHeight*spriteMod, x() + width(), y(), -width(), height());
        }
    }

    public void tick(double timeDelta) {
        double mod = 1.0 + timeDelta/3*2;
        double w = width();
        double w2 = w * mod;
        double h = height() * mod;
        setSize(w2, h);
        move((w - w2) * (getForces().x < 0.0 ? 1.0 : -1.0) , 0);
    }

}
