package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileReader {
    private static final String SETTINGS_FILE_PATH = new File("src/test/resources/settings.json").getAbsolutePath();
    private static final String TEST_DATA_FILE_PATH = new File("src/test/resources/testData.json").getAbsolutePath();
    private static FileReader instance = null;
    private Map<String, String> settings;
    private Map<String, String> testData;


    private FileReader() {
        this.settings = getMapWithData(SETTINGS_FILE_PATH);
        this.testData = getMapWithData(TEST_DATA_FILE_PATH);
    }

    public static FileReader getInstance() {
        if (instance == null)
            instance = new FileReader();
        return instance;
    }

    private Map<String, String> getMapWithData(String path) {
        Map<String, String> myMap = null;
        try {
            byte[] mapData = Files.readAllBytes(Paths.get(path));
            ObjectMapper objectMapper = new ObjectMapper();
            myMap = new HashMap<String, String>();
            myMap = objectMapper.readValue(mapData, HashMap.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return myMap;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public Map<String, String> getTestData() {
        return testData;
    }
}
