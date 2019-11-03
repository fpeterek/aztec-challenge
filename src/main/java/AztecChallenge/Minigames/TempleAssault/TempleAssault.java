package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import AztecChallenge.GameEngine.Utils.Vector2d;
import javafx.scene.paint.Color;

public class TempleAssault extends Engine {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private SpearCreator spearCreator;

    public TempleAssault() {

        super(WIDTH, HEIGHT);

        enableGravity();
        setWindowTitle("Temple Assault");

        RectanglePlatform rp = new RectanglePlatform(0, 700, WIDTH, 200);
        rp.color = Color.BEIGE;
        platforms.add(rp);

        player = new TAPlayer((width() / 2) - (50 / 2), 500, 50, 100);

        spearCreator = new SpearCreator(new Vector2d(150, 8), new Vector2d(width(), height()),
                new Vector2d(610, 680));

    }

    @Override
    protected boolean isRunning() {
        return windowIsOpen() && player.isAlive();
    }

    @Override
    protected void tick(double timedelta) {

        if (entities.isEmpty()) {
            entities.add(spearCreator.createSpear());
        }

        player.tick(timedelta);

    }


}
