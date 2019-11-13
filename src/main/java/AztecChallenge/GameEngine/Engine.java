package AztecChallenge.GameEngine;

import AztecChallenge.GameEngine.Utils.GameOverText;
import AztecChallenge.Interfaces.Damaging;
import AztecChallenge.Interfaces.Hitboxed;
import AztecChallenge.Interfaces.Jumping;
import AztecChallenge.Interfaces.Renderable;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Utils.RenderWindow;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class Engine {

    private RenderWindow window;
    private boolean gravityOn = true;
    private long lastTimeMeasured;
    private double gForce = 1.0;

    protected Player player;
    protected List<Platform> platforms;
    protected List<GameEntity> entities;
    protected List<Renderable> renderables;

    protected double width() {
        return window.width();
    }

    protected double height() {
        return window.height();
    }

    protected void setG(double g) {
        gForce = g;
    }

    private void setEventHandler() {

        window.onKeyPress(new EventHandler<KeyEvent>()
        {
            public void handle(KeyEvent e)
            {

                String code = e.getCode().toString();

                if (e.getCode() == KeyCode.ESCAPE) {
                    window.close();
                }
                else if (code.equals("W")) {
                    player.onUp();
                }
                else if (code.equals("A")) {
                    player.onLeft();
                }
                else if (code.equals("S")) {
                    player.onDown();
                }
                else if (code.equals("D")) {
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
        entities = new ArrayList<>();
        renderables = new ArrayList<>();
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

    private void handleCollisions() {
        for (GameEntity e : entities) {
            if (e instanceof Damaging && e.intersects((Hitboxed) player)) {
                player.onHit();
            }
        }
    }

    private void handleGravity(GameEntity e, double timeDelta) {
        if (!e.affectedByGravity()) {
            return;
        }
        e.move(0, e.getForces().y * timeDelta * 1000);
        e.setForces(e.getForces().x, Math.min(e.getForces().y += timeDelta * gForce, 10));
    }

    private void platformCollision() {
        for (Platform p : platforms) {
            if (p.hasMass() && p.intersects(player.hitbox())) {
                player.move(0, p.y() - (player.y() + player.height()));
                player.setForces(player.getForces().x, 0.0);
                if (player instanceof Jumping) {
                    ((Jumping) player).canJump(true);
                }
                break;
            }
        }
    }

    private void handleGravity(double timeDelta) {

        handleGravity(player, timeDelta);

        if (player.hasMass()) {
            platformCollision();
        }

        for (GameEntity e : entities) {
            handleGravity(e, timeDelta);
        }

    }

    private void gravity(double timeDelta) {
        if (gravityOn) {
            handleGravity(timeDelta);
        }
    }

    private void moveEntity(GameEntity e, double timeDelta) {

        double dx = e.getForces().x * timeDelta * 100;
        double dy = e.getForces().y * timeDelta * 100;

        if (gravityOn && e.affectedByGravity()) {
            dy = 0;
        }

        e.move(dx, dy);

    }

    private void movePlayer(double timeDelta) {

        moveEntity(player, timeDelta);

    }

    private void move(double timeDelta) {

        movePlayer(timeDelta);
        for (GameEntity entity : entities) {
            moveEntity(entity, timeDelta);
        }

    }

    private void render() {

        window.clear();

        for (Renderable r : renderables) {
            window.render(r);
        }

        for (Platform p : platforms) {
            if (p instanceof Renderable) {
                window.render((Renderable)p);
            }
        }

        window.render(player);

        for (GameEntity e : entities) {
            if (e instanceof Renderable) {
                window.render((Renderable) e);
            }
        }

    }

    private void removeEntities() {

        double winWidth = window.width();
        double winHeight = window.height();

        for (GameEntity e : entities) {
            if (e.x() + e.width() < -10 || e.x() > winWidth + 10) {
                e.onDelete();
                entities.remove(e);
                continue;
            }
            if (e.y() + e.height() < -10 || e.y() > winHeight + 10) {
                e.onDelete();
                entities.remove(e);
            }
        }
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

    private void displayGameOver() {

        GameOverText text = new GameOverText(width() / 2, height() / 2);
        window.render(text);

    }

    public void run() {

        measureTimeDelta();

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                double timeDelta = measureTimeDelta() / 1000.f;
                gravity(timeDelta);
                move(timeDelta);
                handleCollisions();
                removeEntities();
                tick(timeDelta);
                render();
                if (!windowIsOpen() || !isRunning()) {
                    this.stop();
                    displayGameOver();
                }
            }

        }.start();

    }

}
