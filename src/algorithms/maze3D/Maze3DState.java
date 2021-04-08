package algorithms.maze3D;

import algorithms.Search.AState;

public class Maze3DState extends AState {
    Position3D pos;

    public Maze3DState(Position3D pos,AState state) {
        if (pos== null)
        {
            System.out.println("The position is null");
            System.exit(0);
        }
        this.pos = pos;
        this.state=pos.toString();
        this.comeFrom=state;
    }


    /**
     * @return return the cost of the move between two states
     */
    @Override
    public int getCost() {
        return 10;
    }

    /**
     * @return the number of the row of the state
     */
    public int getX()
    {
        return pos.getRowIndex();
    }

    /**
     * @return the number of the column of the state
     */
    public int getY()
    {
        return pos.getColumnIndex();
    }

    /**
     * @return the number of the depth of the state
     */
    public  int getZ()
    {
        return  pos.getDepthIndex();
    }
}
