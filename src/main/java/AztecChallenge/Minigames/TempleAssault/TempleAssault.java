package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import javafx.scene.paint.Color;

public class TempleAssault extends Engine {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    public TempleAssault() {
        super(WIDTH, HEIGHT);
        enableGravity();
        setWindowTitle("Temple Assault");
        RectanglePlatform rp = new RectanglePlatform(0, 700, WIDTH, 50);
        player = new TAPlayer(100, 500, 50, 100);
        rp.color = Color.BEIGE;
        platforms.add(rp);
    }

    @Override
    protected boolean isRunning() {
        return windowIsOpen();
    }

    @Override
    protected void tick(long timedelta) {



    }


}
