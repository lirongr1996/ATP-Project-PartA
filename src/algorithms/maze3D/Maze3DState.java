package algorithms.maze3D;

import algorithms.search.AState;

public class Maze3DState extends AState {
    Position3D pos;

    public Maze3DState(Position3D pos,AState state) throws Exception {
        if (pos== null)
            throw new Exception("The position is null");
        this.pos = pos;
        this.state=pos.toString();
        this.comeFrom=state;
        if (state==null)
            this.cost=0;
        else
            this.cost=10+this.comeFrom.getCost();
    }


    /**
     * @return return the cost of the move between two states
     */
    @Override
    public int getCost() {
        return this.cost;
    }

    /**
     * @return the number of the row in the state
     */
    public int getX()
    {
        return pos.getRowIndex();
    }

    /**
     * @return the number of the column in the state
     */
    public int getY()
    {
        return pos.getColumnIndex();
    }

    /**
     * @return the number of the depth in the state
     */
    public  int getZ()
    {
        return  pos.getDepthIndex();
    }
}
