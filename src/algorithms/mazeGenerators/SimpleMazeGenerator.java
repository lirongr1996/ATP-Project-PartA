package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{



    @Override
    public Maze generate(int row, int col) {
        Random rand=new Random();
        Maze m=new Maze(row,col);
        int [][] maze=m.getTwoDMaze();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=rand.nextInt(2);
            }
        }
        for (int i = 0; i < col; i++) {
            maze[0][i]=0;
        }
        for (int i = 0; i < row; i++) {
            maze[i][col-1]=0;
        }

        return  m;
    }
}
