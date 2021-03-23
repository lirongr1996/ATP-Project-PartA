package algorithms.mazeGenerators;

public abstract class AMazeGenerator {

    public abstract Maze generate(int row, int col);

    public long measureAlgorithmTimeMillis(int row, int col)
    {
        long before=System.currentTimeMillis();
        generate(row,col);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
