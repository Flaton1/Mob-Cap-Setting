package fr.flaton.mobcapsetting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Config {

    private final File CONFIG_FILE;

    public static int monster = 70;
    public static int creature = 10;
    public static int ambient = 15;
    public static int axolotls = 5;
    public static int underground_water_creature = 5;
    public static int water_creature = 5;
    public static int water_ambient = 20;

    public Config(Path ConfigFolder) {
        this.CONFIG_FILE = new File(ConfigFolder.toString(), "MobCapSetting.properties");
    }

    public void loadConfig() {
        Properties properties = new Properties();

        if (CONFIG_FILE.exists()) {
            try {
                FileInputStream stream = new FileInputStream(CONFIG_FILE);
                properties.load(stream);
                stream.close();

                // Set values from loaded config
                monster = Integer.parseInt(properties.getProperty("monster", "70"));
                creature = Integer.parseInt(properties.getProperty("creature", "10"));
                ambient = Integer.parseInt(properties.getProperty("ambient", "15"));
                axolotls = Integer.parseInt(properties.getProperty("axolotls", "5"));
                underground_water_creature = Integer.parseInt(properties.getProperty("underground_water_creature", "5"));
                water_creature = Integer.parseInt(properties.getProperty("water_creature", "5"));
                water_ambient = Integer.parseInt(properties.getProperty("water_ambient", "20"));

                createConfig(mapConfig());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Create default config file
            createConfig(mapConfig());
        }
    }



    private static Map<String, String> mapConfig() {
        Map<String, String> config = new LinkedHashMap<>();

        config.put("# Mob Cap Config File", "");
        config.put("# RESTART REQUIRED TO APPLY", "");
        config.put("\n# Mob cap for monsters (zombies, creepers, etc). Default: 70", "");
        config.put("monster", String.valueOf(monster));
        config.put("\n# Mob cap for creatures (neutral mods, bees, sheep, cows, etc). Default: 10", "");
        config.put("creature", String.valueOf(creature));
        config.put("\n# Mob cap for ambient creatures (bats). Default: 15", "");
        config.put("ambient", String.valueOf(ambient));
        config.put("\n# Mob cap for axolotls. Default: 5", "");
        config.put("axolotls", String.valueOf(axolotls));
        config.put("\n# Mob cap for underground water creatures (glowsquid). Default: 5", "");
        config.put("underground_water_creature", String.valueOf(underground_water_creature));
        config.put("\n# Mob cap for water creatures (squid, dolphins, etc). Default: 5", "");
        config.put("water_creature", String.valueOf(water_creature));
        config.put("\n# Mob cap for ambient water creatures (fish). Default: 20", "");
        config.put("water_ambient", String.valueOf(water_ambient));

        return config;
    }

    private void createConfig(Map<String, String> config) {
        try {
            FileOutputStream output = new FileOutputStream(CONFIG_FILE);

            for (Map.Entry<String, String> entry : config.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String line;
                if (value.matches("")) {
                    line = String.format("%s%s\n", key, value);
                } else {
                    line = String.format("%s=%s\n", key, value);
                }
                output.write(line.getBytes());
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
