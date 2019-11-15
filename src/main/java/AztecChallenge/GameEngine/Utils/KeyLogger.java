package AztecChallenge.GameEngine.Utils;

import javafx.util.Pair;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class KeyLogger {

    private BufferedWriter writer;
    private FileOutputStream file;
    private Map<String, Pair<Long, Long>> map;
    private long counter = 0;

    public KeyLogger(String logPath) throws IOException {

        if (logPath.startsWith("~")) {
            logPath = logPath.replaceFirst("~", System.getProperty("user.home"));
        }
        logPath = logPath.endsWith("/") || logPath.isEmpty() ? logPath : logPath.concat("/");

        String path = String.format("%saztec_log-%d.log", logPath, System.currentTimeMillis());
        file = new FileOutputStream(path);
        writer = new BufferedWriter(new OutputStreamWriter(file));
        map = new HashMap<>();

    }

    public void keyDown(String key) {

        if (map.containsKey(key)) {
            return;
        }

        map.put(key, new Pair<>(System.currentTimeMillis(), counter++));

    }

    public void keyUp(String key) {

        if (!map.containsKey(key)) {
            return;
        }

        try {
            long order = map.get(key).getValue();
            long timePressed = System.currentTimeMillis() - map.get(key).getKey();
            writer.write(String.format("%d) '%s' <%d ms>\n", order, key, timePressed));
        } catch (IOException e) {
            System.out.println("String could not be written to file");
        }

        map.remove(key);

    }

    public void closeStream() {
        try {
            writer.write("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Writer could not be flushed or closed");
        }
    }

}
