package algorithms.maze3D;

public class Position3D {
    private int row;
    private int column;
    private int depth;

    public Position3D(int row, int column, int depth) {
        if (depth<0 || row<0 || column<0){
            System.out.println("cant create position because the negative data");
            System.exit(0);
        }
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
    public void setRow(int row) {
        if (row<0){
            System.out.println("The position is out of the bounds");
            System.exit(0);
        }
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
    public void setColumn(int column) {
        if (column<0) {
            System.out.println("The position is out of the bounds");
            System.exit(0);
        }
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
    public void setDepth(int depth){
        if (depth<0) {
            System.out.println("The position is out of the bounds");
            System.exit(0);
        }
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "{"+this.row+","+this.column+","+this.depth+"}";
    }
}
