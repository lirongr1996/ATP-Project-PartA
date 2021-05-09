package algorithms.mazeGenerators;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
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
     * @param row is row number in the position
     * @param col is column number in the  position
     */
    public Position(int row, int col) throws Exception {
        if (row<0 || col<0)
            throw new Exception("Can't create position because the negative data");
        this.row=row;
        this.column=col;
    }

    /**
     * @return the row number in the position
     */
    public int getRowIndex()
    {
        return this.row;
    }

    /**
     * @return the column number in the  position
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
