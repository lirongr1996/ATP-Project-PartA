package algorithms.test;

import  algorithms.mazeGenerators.*;

import java.io.File;
import java.nio.*;

public class RunMazeGenerator {
    public static void main(String[] args) {
        testMazeGenerator(new EmptyMazeGenerator());
        testMazeGenerator(new SimpleMazeGenerator());
        testMazeGenerator(new MyMazeGenerator());
    }

    private static void testMazeGenerator(IMazeGenerator mazeGenerator) {
// prints the time it takes the algorithm to run
        try {
            System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(1000/*rows*/, 1000/*columns*/)));
// generate another maze
            Maze maze = mazeGenerator.generate(5/*rows*/, 5/*columns*/);
// prints the maze
            maze.print();
// get the maze entrance
            Position startPosition = maze.getStartPosition();
// print the start position
            System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
// prints the maze exit position
            System.out.println(String.format("Goal Position: %s", maze.getGoalPosition()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
