package AztecChallenge.GameEngine.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigParser {

    private List<String> loadFile(String path) {

        List<String> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;

    }

    private Map<String, String> toMap(List<String> list) {

        Map<String, String> map = new HashMap<>();

        for (String line : list) {

            String[] split = line.split("=", 2);
            if (split.length < 2) {
                continue;
            }
            map.put(split[0].replace("=", ""), split[1]);

        }

        return map;

    }

    public Config parseConfig(String path) {

        Map<String, String> map = toMap(loadFile(path));
        //map.keySet().forEach(System.out::println);

        String up = map.getOrDefault("up", "W");
        String down = map.getOrDefault("down", "S");
        String left = map.getOrDefault("left", "A");
        String right = map.getOrDefault("up", "D");
        int width = Integer.parseInt(map.getOrDefault("width", "1600"));
        int height = Integer.parseInt(map.getOrDefault("height", "900"));
        String font = map.getOrDefault("font", "/lcd_solid.ttf");

        return new Config(up, down, left, right, width, height, font);

    }

}
