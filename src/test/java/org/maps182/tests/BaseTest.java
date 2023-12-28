package org.maps182.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {
    public WebDriver intilizeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + File.separator + "src" + File.separator + "test" + File.separator + "java" +
                File.separator + "org" + File.separator + "maps182" +
                File.separator + "resources" + File.separator + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        // convert json file content to json string
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")
                + File.separator + "src" + File.separator + "test" + File.separator + "java" +
                File.separator + "org" + File.separator + "maps182" +
                File.separator + "resources" + File.separator + jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        // TypeReference is to say that we want to deserialize the JSON to a List of HashMaps
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
        System.out.println(data);
        return data;
    }
}
