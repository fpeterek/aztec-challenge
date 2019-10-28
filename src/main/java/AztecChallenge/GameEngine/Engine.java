package AztecChallenge.GameEngine;

import AztecChallenge.Interfaces.Renderable;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Utils.RenderWindow;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;

public abstract class Engine {

    private RenderWindow window;
    private boolean gravityOn = true;
    private long lastTimeMeasured;

    protected List<Platform> platforms;

    protected Engine(int width, int height) {
        platforms = new ArrayList<>();
        window = new RenderWindow(width, height);
        lastTimeMeasured = System.currentTimeMillis();
        window.show();
    }

    protected void setWindowTitle(String title) {
        window.setTitle(title);
    }

    protected void enableGravity() {
        gravityOn = true;
    }

    protected void disableGravity() {
        gravityOn = false;
    }

    public boolean gravityEnabled() {
        return gravityOn;
    }

    private void handleMovement() {

    }

    private void handleCollisions() {

    }

    protected void render() {

        window.clear();

        for (Platform p : platforms) {
            if (p instanceof Renderable) {
                window.render((Renderable)p);
            }
        }



    }

    protected long measureTimeDelta() {
        long currTime = System.currentTimeMillis();
        long timeDelta = currTime - lastTimeMeasured;
        lastTimeMeasured = currTime;
        return timeDelta;
    }

    public boolean windowIsOpen() {
        return window.isOpen();
    }

    protected abstract void tick(long deltaMS);
    protected abstract boolean isRunning();

    public void run() {

        measureTimeDelta();

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (!windowIsOpen()) {
                    this.stop();
                }
                tick(measureTimeDelta());
            }

        }.start();

    }

}
