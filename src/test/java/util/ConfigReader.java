package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {                        // CONFIG OKUYUCU

    private String url;                            // Bu bilgiler config.properties de
    private String chromeDriverPath;               // ( URL ve Browser)

    public ConfigReader(){                          // Constroctor var
        Properties prop = new Properties();
        InputStream input = null;
        try{
            input = new FileInputStream("config.properties");   // Bu dosyayi bulucaz
            //Load a properties file
            prop.load(input);                                         //Dosyayi yukluyoruz
            //get the property vlaue and print it out
            this.url = prop.getProperty("url");       // Constroctor bizim verdigimiz URL i alicak
            this.chromeDriverPath = prop.getProperty("chrome_driver_path"); // Driverimiz artik biz ne girersek o olacak
        }catch (IOException e){     // Dosyayi bulamadiysan
            e.printStackTrace();
        }finally {
            if (input != null){     // Dosyayi yuklediysen
                try{
                    input.close();      // Baglantiyi kapat
                }catch(IOException e){
                    e.printStackTrace();   // Kapatamadiysan
                }
            }
        }
    }

    public String getUrl(){                 // URL i getirir
        return url;
    }
    public String getChromeDriverPath(){    // Browseri  getirir
        return chromeDriverPath;
    }
}


