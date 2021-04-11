package algorithms.maze3D;

public abstract class AMaze3DGenerator implements IMaze3DGenerator{

    public abstract Maze3D generate(int depth, int row, int column) throws Exception;


    /**
     * @param row is the number of maze rows.
     * @param column is the number of maze column.
     * @param depth is the number of maze depth.
     * @return the time it takes to create the maze
     */
    public long measureAlgorithmTimeMillis(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0 || (row==1 && column==1)){
            throw new Exception("The data of create maze is out of bounds");
        }
        long before=System.currentTimeMillis();
        generate(depth,row,column);
        long after=System.currentTimeMillis();
        return after-before;
    }
}
