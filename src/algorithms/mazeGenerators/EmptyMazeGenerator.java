package algorithms.mazeGenerators;

import java.util.Random;

public class EmptyMazeGenerator extends AMazeGenerator {

    /**
     * @param row is the number of the maze rows.
     * @param col is the number of the maze columns.
     * @return the maze that created
     */
    @Override
    public Maze generate(int row, int col) throws Exception {
        if (row < 0 || col<0 ||(row==1 && col==1))
            throw new Exception("the data of create maze is out of bounds");
        Maze m=new Maze(row,col);
        Random rand=new Random();
        int [][] maze=m.getTwoDMaze();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=0;
            }
        }
        //set start and goal positions int the maze.
        m.setStart(new Position(0, rand.nextInt(col)));
        m.setGoal(new Position(row-1,rand.nextInt(col)));
        return  m;
    }
}
