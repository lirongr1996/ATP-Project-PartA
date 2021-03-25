package algorithms.mazeGenerators;

import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator {
    public EmptyMazeGenerator() {
    }

    @Override
    public Maze generate(int row, int col) {
        Maze m=new Maze(row,col);
        Random rand=new Random();
        int [][] maze=m.getTwoDMaze();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=0;
            }
        }

        m.setStart(new Position(0, rand.nextInt(col)));
        m.setGoal(new Position(row-1,rand.nextInt(col)));
        return  m;
    }
}
