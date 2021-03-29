package algorithms.maze3D;

import algorithms.Search.AState;

public class Maze3DState extends AState {
    Position3D pos;

    public Maze3DState(Position3D pos,AState state) {
        this.pos = pos;
        this.state=pos.toString();
        this.comeFrom=state;
    }



    @Override
    public int getCost() {
        return 10;
    }

    public int getX()
    {
        return pos.getRowIndex();
    }

    public int getY()
    {
        return pos.getColumnIndex();
    }

    public  int getZ()
    {
        return  pos.getDepthIndex();
    }
}
