package fr.mower.config;

import java.io.*;
import java.util.*;

public class ConfigReader {

    private static ConfigReader configReader;

    private static final String CONFIG_FILE_PATH = "/pelouse-config.txt";

    private List<String> config;

    private ConfigReader() {
        readConfig();
    }

    public static ConfigReader getInstance(){
        if(configReader == null)
            configReader = new ConfigReader();
        return configReader;
    }

    private List<String> readConfig(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(this.getClass().getResourceAsStream(CONFIG_FILE_PATH))))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            config = Arrays.asList(
                    sb.toString()
                            .split("(\\s*)\r(\\s*)")[0]
                            .split("\\s* \\s*")
            );
            return config;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getConfig() {
        return config;
    }
}
