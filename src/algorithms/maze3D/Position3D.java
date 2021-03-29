package algorithms.maze3D;

public class Position3D {
    private int row;
    private int column;
    private int depth;

    public Position3D(int row, int column, int depth) {
        this.row = row;
        this.column = column;
        this.depth = depth;
    }

    public int getRowIndex() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumnIndex() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getDepthIndex() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "{"+this.row+","+this.column+","+this.depth+"}";
    }
}
