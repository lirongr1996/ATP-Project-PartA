package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {

    public abstract Maze generate(int row, int col);

    public long measureAlgorithmTimeMillis(int row, int col)
    {
        if (row<=0 || col<=0 || (row==1 && col==1))
            return 0;
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
