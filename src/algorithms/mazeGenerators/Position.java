package algorithms.mazeGenerators;

public class Position {
    private int row;
    private int column;

    public Position(int row, int col) {
        if (row<=0 || col<=0 || (row==1 && col==1))
            return ;
        this.row=row;
        this.column=col;
    }

    public int getRowIndex()
    {
        return this.row;
    }

    public  int getColumnIndex()
    {
        return this.column;
    }

    @Override
    public String toString() {
        return "{"+this.row+","+this.column+"}";
    }
}
