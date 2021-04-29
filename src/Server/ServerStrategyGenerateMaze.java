package Server;

import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.SimpleMazeGenerator;

import java.io.*;
import java.nio.channels.Channels;
import java.util.Locale;
import java.util.Properties;

public class ServerStrategyGenerateMaze implements IServerStrategy{

    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);

            int[] al = (int[]) fromClient.readObject();
            try(InputStream input = new FileInputStream("C:\\Users\\liron\\IdeaProjects\\ATP-Project-PartB\\resources\\config.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                IMazeGenerator mazeGenerator=null;
                if (prop.getProperty("mazeGeneratingAlgorithm").equals("EmptyMazeGenerator"))
                    mazeGenerator=new EmptyMazeGenerator();
                if (prop.getProperty("mazeGeneratingAlgorithm").equals("SimpleMazeGenerator"))
                    mazeGenerator=new SimpleMazeGenerator();
                if (prop.getProperty("MyMazeGenerator").equals("MyMazeGenerator"))
                    mazeGenerator=new EmptyMazeGenerator();
                Maze maze=mazeGenerator.generate(al[0],al[1]);
                byte[] b = maze.toByteArray();
                outToClient.write(b);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            toClient.flush();

            fromClient.close();
            toClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
