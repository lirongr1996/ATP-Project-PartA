package algorithms.maze3D;

public class Position3D {
    private int row;
    private int column;
    private int depth;

    public Position3D(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0)
            throw new Exception("The data of create maze is out of bounds");
        this.row = row;
        this.column = column;
        this.depth = depth;
    }

    /**
     * @return the row number in the  position
     */
    public int getRowIndex() {
        return row;
    }

    /**
     * @param row is the new number of the row in the position
     */
    public void setRow(int row) throws Exception {
        if (row<0)
            throw new Exception("The position is out of the bounds");
        this.row = row;
    }

    /**
     * @return the column number in the  position
     */
    public int getColumnIndex() {
        return column;
    }

    /**
     * @param column is the new number of the column in the position
     */
    public void setColumn(int column) throws Exception {
        if (column<0)
            throw new Exception("The position is out of the bounds");
        this.column = column;
    }

    /**
     * @return the depth number in the  position
     */
    public int getDepthIndex() {
        return depth;
    }

    /**
     * @param depth is the new number of the depth in the position
     */
    public void setDepth(int depth) throws Exception {
        if (depth<2)
            throw new Exception("The position is out of the bounds");
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "{"+this.row+","+this.column+","+this.depth+"}";
    }
}
