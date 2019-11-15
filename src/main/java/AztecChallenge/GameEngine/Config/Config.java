package AztecChallenge.GameEngine.Config;

public class Config {

    public final String up;
    public final String down;
    public final String left;
    public final String right;
    public final int width;
    public final int height;
    public final String font;
    public final String logPath;
    public final boolean keyLoggerOn;

    public Config(String u, String d, String l, String r, int w, int h, String f, String lp, boolean kl) {
        up = u;
        down = d;
        left = l;
        right = r;
        width = w;
        height = h;
        font = f;
        logPath = lp;
        keyLoggerOn = kl;
    }

}
