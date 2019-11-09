package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.Interfaces.Renderable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Enemy extends GameEntity implements Renderable {

    public Color color;

    public Enemy(double x, double y, double width, double height) {
        super(x, y, width, height);
        color = new Color(0.5,0.3, 0.2, 1);
        affectedByGravity(false);
    }


    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(color.toString()));
        gc.fillRect(x(), y(), width(), height());
    }

    public void tick(double timeDelta) {
        double mod = 1.0 + timeDelta/3;
        double w = width();
        double w2 = w * mod;
        double h = height() * mod;
        setSize(w2, h);
        move((w - w2) * (getForces().x < 0.0 ? 1.0 : -1.0) , 0);
    }

}
