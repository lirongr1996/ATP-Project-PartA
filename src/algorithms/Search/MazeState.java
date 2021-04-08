package algorithms.Search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState{
    Position pos;

    public MazeState(Position pos,AState state) throws Exception {
        if (pos==null)
            throw new Exception("the position is null");
        this.pos = pos;
        this.state=pos.toString();
        this.comeFrom=state;
        if (state!=null) {
            int x = Integer.parseInt(comeFrom.state.substring(1, comeFrom.state.indexOf(",")));
            int y = Integer.parseInt(comeFrom.state.substring(comeFrom.state.indexOf(",") + 1, comeFrom.state.length() - 1));

            if ((x == pos.getRowIndex() - 1 && y == pos.getColumnIndex() - 1) || (x == pos.getRowIndex() + 1 && y == pos.getColumnIndex() + 1) || (x == pos.getRowIndex() + 1 && y == pos.getColumnIndex() - 1) || (x == pos.getRowIndex() - 1 && y == pos.getColumnIndex() + 1))
                cost = 15;
            else
                cost = 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(pos, mazeState.pos);
    }

    /**
     * @return the cost that take to move between two states
     */
    public int getCost()
    {
        return cost;
    }

    /**
     * @return the number of the row of the state
     */
    public int getX()
    {
        return pos.getRowIndex();
    }

    /**
     * @return the number of the colum of the state
     */
    public int getY()
    {
        return pos.getColumnIndex();
    }
}
