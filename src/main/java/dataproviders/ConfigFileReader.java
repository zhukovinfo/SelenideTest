package dataproviders;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader(){
        loadPropertiesFile();
    }

    public String getUrl(){
        String url = properties.getProperty("url");

        if (url == null){
            throw new RuntimeException("Url key not found");
        }

        return url;
    }


    private void loadPropertiesFile(){
        InputStream inputStream =getClass().getClassLoader().getResourceAsStream("config.properties");

        if (inputStream == null){
            throw new RuntimeException("Config.properties file not found");
        }

        try {
            properties = new Properties();
            properties.load(inputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        try{
            if (inputStream != null) inputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
