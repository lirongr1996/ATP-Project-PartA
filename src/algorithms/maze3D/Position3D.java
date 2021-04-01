package algorithms.maze3D;

public class Position3D {
    private int row;
    private int column;
    private int depth;

    public Position3D(int row, int column, int depth) {
        if (depth<=0 || row<=0 || column<=0 || (row==1 && column==1))
            return;
        this.row = row;
        this.column = column;
        this.depth = depth;
    }

    public int getRowIndex() {
        return row;
    }

    public void setRow(int row) {
        if (row<=0)
            return;
        this.row = row;
    }

    public int getColumnIndex() {
        return column;
    }

    public void setColumn(int column) {
        if (column<=0)
            return;
        this.column = column;
    }

    public int getDepthIndex() {
        return depth;
    }

    public void setDepth(int depth) {
        if (depth<=0)
            return;
        this.depth = depth;
    }

    @Override
    public String toString()
    {
        return "{"+this.row+","+this.column+","+this.depth+"}";
    }
}
