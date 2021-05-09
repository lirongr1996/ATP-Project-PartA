package algorithms.test;
import IO.*;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import java.io.*;
import java.util.Arrays;

public class RunCompressDecompressMaze {
    public static void main(String[] args) {
        String mazeFileName = "savedMaze.maze";
        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        try {
            Maze maze = mazeGenerator.generate(1000, 1000); //Generate new maze
            try {
// save maze to a file
                OutputStream out = new MyCompressorOutputStream(new FileOutputStream(mazeFileName));
                byte [] temp=maze.toByteArray();
                out.write(temp);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte savedMazeBytes[] = new byte[0];
            try {
//read maze from file
                InputStream in = new MyDecompressorInputStream(new FileInputStream(mazeFileName));
                savedMazeBytes = new byte[maze.toByteArray().length];
                in.read(savedMazeBytes);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Maze loadedMaze = new Maze(savedMazeBytes);
//            maze.print();
//            System.out.println("--------------");
//            loadedMaze.print();
            boolean areMazesEquals = Arrays.equals(loadedMaze.toByteArray(), maze.toByteArray());
            System.out.println(String.format("Mazes equal: %s", areMazesEquals));
//maze should be equal to loadedMaze
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}