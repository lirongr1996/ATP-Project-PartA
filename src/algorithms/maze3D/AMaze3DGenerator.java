package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMazeGenerator3D{

    public abstract Maze3D generate(int depth, int row, int column) throws Exception;

    public long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0 || (row==1 && column==1)){
            throw new Exception("the data of create maze is negative");
        }
        long before=System.currentTimeMillis();
        generate(depth,row,column);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
