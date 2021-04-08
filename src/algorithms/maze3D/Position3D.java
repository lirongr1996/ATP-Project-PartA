package algorithms.maze3D;

public class Position3D {
    private int row;
    private int column;
    private int depth;

    public Position3D(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0)
            throw new Exception("cant create position because the negative data");
        this.row = row;
        this.column = column;
        this.depth = depth;
    }

    /**
     * @return the number of the row of the position
     */
    public int getRowIndex() {
        return row;
    }

    /**
     * @param row is the new number of the row of the position
     */
    public void setRow(int row) throws Exception {
        if (row<0)
            throw new Exception("The position is out of the bounds");
        this.row = row;
    }

    /**
     * @return the number of the column of the position
     */
    public int getColumnIndex() {
        return column;
    }

    /**
     * @param column is the new number of the column of the position
     */
    public void setColumn(int column) throws Exception {
        if (column<0)
            throw new Exception("The position is out of the bounds");
        this.column = column;
    }

    /**
     * the number of the depth of the position
     */
    public int getDepthIndex() {
        return depth;
    }

    /**
     * @param depth is the new number of the depth of the position
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
