package algorithms.test;

import algorithms.maze3D.*;

public class RunMaze3DGenerator {
    public static void main(String[] args) {
        testMazeGenerator(new MyMaze3DGenerator());
    }


    private static void testMazeGenerator(IMazeGenerator3D mazeGenerator) {
// prints the time it takes the algorithm to run
        try {
            System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(100/*rows*/,100,100)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

// generate another maze
        Maze3D maze = null;
        try {
            maze = mazeGenerator.generate(3,6,20);
        } catch (Exception e) {
            e.printStackTrace();
        }

// prints the maze
        maze.print();
// get the maze entrance
        Position3D startPosition = maze.getStartPosition();
// print the start position
        System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
// prints the maze exit position
        System.out.println(String.format("Goal Position: %s", maze.getGoalPosition()));
    }
}
