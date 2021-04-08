package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    public abstract Maze generate(int row, int col) throws Exception;

    /**
     * @param row is the number of the rows of the maze
     * @param col is the number of the columns of the maze
     * @return the time is take to create the maze
     */
    public long measureAlgorithmTimeMillis(int row, int col) throws Exception {
        if (row<0 || col< 0)
            throw new Exception("Can't create maze because the negative data");
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
