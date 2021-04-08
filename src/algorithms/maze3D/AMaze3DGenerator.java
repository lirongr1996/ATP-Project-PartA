package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    public abstract Maze3D generate(int depth, int row, int column);

    public long measureAlgorithmTimeMillis(int depth, int row, int column)
    {
        if (depth<0 || row<0 || column<0 || (row==1 && column==1)){
            System.out.println("The position is out of the bounds");
            System.exit(0);
        }
        long before=System.currentTimeMillis();
        generate(depth,row,column);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
