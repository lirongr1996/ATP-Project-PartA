package Server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Configurations {
    private static Configurations instance=null;

    private Configurations()
    {
        try (OutputStream output = new FileOutputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("threadPoolSize", "2");
            prop.setProperty("mazeGeneratingAlgorithm", "MyMazeGenerator");
            prop.setProperty("mazeGeneratingAlgorithm", "BestFirstSearch");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static Configurations getInstance()
    {
        if (instance==null)
            instance=new Configurations();
        return instance;
    }
}
