package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static FileInputStream input ;
    static Properties prop ;

    public static String getProperty(String key) {
        try {
            input = new FileInputStream("C:/Users/LNV-24/IdeaProjects/eAmataPOMFramework/src/test/resources/testData/config.properties");
            prop = new Properties();
            prop.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("File Not Found!....");
        }
        return prop.getProperty(key);
    }


}
