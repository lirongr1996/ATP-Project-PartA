package algorithms.mazeGenerators;

import java.io.Serializable;

public abstract class AMazeGenerator implements IMazeGenerator , Serializable {

    public abstract Maze generate(int row, int col) throws Exception;

    /**
     * @param row is the number of maze rows.
     * @param col is the number of maze columns.
     * @return the time it takes to create the maze
     */
    public long measureAlgorithmTimeMillis(int row, int col) throws Exception {
        if (row<0 || col< 0 ||(row==1 && col==1))
            throw new Exception("the data of create maze is out of bounds");
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
