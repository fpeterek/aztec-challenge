package AztecChallenge.Interfaces;

public interface Jumping {

    void canJump(boolean canObjectJump);
    boolean canJump();
    void jump();
    default void jump(double force) {
        jump();
    }
}
