package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class WebProperties {
    private static HashMap<String, String> data = new HashMap<>();
    public String get(String name) throws IOException {
        readFile();
        return data.get(name);
    }

    public void readFile() throws IOException {
        try {
            File file = new File(System.getProperty("user.dir")+"/src/application.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                data.put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
