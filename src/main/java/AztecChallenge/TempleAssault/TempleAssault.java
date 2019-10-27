package AztecChallenge.TempleAssault;

import AztecChallenge.Engine;
import AztecChallenge.RectanglePlatform;
import javafx.scene.paint.Color;

public class TempleAssault extends Engine {

    public TempleAssault() {
        setWindowTitle("Temple Assault");
        RectanglePlatform rp = new RectanglePlatform(0, 700, 1600, 50);
        rp.color = Color.BEIGE;
        platforms.add(rp);
    }

    @Override
    protected boolean isRunning() {
        return true;
    }

    @Override
    protected void tick(long timedelta) {

        render();

    }


}
