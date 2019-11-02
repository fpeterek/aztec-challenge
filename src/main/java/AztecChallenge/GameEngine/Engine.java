package AztecChallenge.GameEngine;

import AztecChallenge.Interfaces.Jumping;
import AztecChallenge.Interfaces.Renderable;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Utils.RenderWindow;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class Engine {

    private RenderWindow window;
    private boolean gravityOn = true;
    private long lastTimeMeasured;

    protected Player player;
    protected List<Platform> platforms;

    protected double width() {
        return window.width();
    }

    protected double height() {
        return window.height();
    }

    private void setEventHandler() {

        window.onKeyPress(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {

                String code = e.getCode().toString();

                if (code.equals("W")) {
                    player.onUp();
                }
                if (code.equals("A")) {
                    player.onLeft();
                }
                if (code.equals("S")) {
                    player.onDown();
                }
                if (code.equals("D")) {
                    player.onRight();
                }
            }
        });

        window.onKeyRelease(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {

                String code = e.getCode().toString();

                if (code.equals("W")) {
                    player.onUpRelease();
                }
                if (code.equals("A")) {
                    player.onLeftRelease();
                }
                if (code.equals("S")) {
                    player.onDownRelease();
                }
                if (code.equals("D")) {
                    player.onRightRelease();
                }
            }
        });

    }

    protected Engine(int width, int height) {
        platforms = new ArrayList<>();
        window = new RenderWindow(width, height);
        lastTimeMeasured = System.currentTimeMillis();
        setEventHandler();
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

    private void handleGravity(double timeDelta) {

        player.move(0, player.getForces().y * timeDelta * 1000);
        player.setForces(player.getForces().x, Math.min(player.getForces().y += timeDelta, 10));

        for (Platform p  : platforms) {
            if (p.intersects(player.hitbox())) {
                player.move(0, p.y() - (player.y() + player.height()));
                player.setForces(player.getForces().x, 0.01);
                if (player instanceof Jumping) {
                    ((Jumping) player).canJump(true);
                }
                break;
            }
        }

    }

    private void gravity(double timeDelta) {
        if (gravityOn) {
            handleGravity(timeDelta);
        }
    }

    private void movePlayer(double timeDelta) {

        double dx = player.getForces().x * timeDelta * 100;
        double dy = player.getForces().y * timeDelta * 100;

        if (gravityOn) {
            dy = 0;
        }

        player.move(dx, dy);

    }

    private void move(double timeDelta) {

        movePlayer(timeDelta);

    }

    private void render() {

        window.clear();

        for (Platform p : platforms) {
            if (p instanceof Renderable) {
                window.render((Renderable)p);
            }
        }

        window.render(player);

    }

    private long measureTimeDelta() {
        long currTime = System.currentTimeMillis();
        long timeDelta = currTime - lastTimeMeasured;
        lastTimeMeasured = currTime;
        return timeDelta;
    }

    protected boolean windowIsOpen() {
        return window.isOpen();
    }

    protected abstract void tick(double delta);
    protected abstract boolean isRunning();

    public void run() {

        measureTimeDelta();

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (!windowIsOpen() || !isRunning()) {
                    this.stop();
                }
                double timeDelta = measureTimeDelta() / 1000.f;
                gravity(timeDelta);
                move(timeDelta);
                tick(timeDelta);
                render();
            }

        }.start();

    }

}
