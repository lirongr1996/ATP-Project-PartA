package algorithms.mazeGenerators;

import java.util.Objects;

public class Position {
    private int row;
    private int column;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    /**
     * @param row is the number of the row of position
     * @param col is the number of the colum of position
     */
    public Position(int row, int col) throws Exception {
        if (row<0 || col<0)
            throw new Exception("can't create position because the negative data");
        this.row=row;
        this.column=col;
    }

    /**
     * @return the number of the row of the position
     */
    public int getRowIndex()
    {
        return this.row;
    }

    /**
     * @return the number of the column of the position
     */
    public  int getColumnIndex()
    {
        return this.column;
    }

    @Override
    public String toString() {
        return "{"+this.row+","+this.column+"}";
    }
}
