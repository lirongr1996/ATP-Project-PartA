package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    public abstract Maze3D generate(int depth, int row, int column);

    public long measureAlgorithmTimeMillis(int depth, int row, int column)
    {
        long before=System.currentTimeMillis();
        generate(depth,row,column);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
