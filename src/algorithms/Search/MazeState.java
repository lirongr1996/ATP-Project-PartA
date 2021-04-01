package algorithms.Search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    Position pos;

    public MazeState(Position pos,AState state) {
        if (pos==null || state==null)
            return;
        this.pos = pos;
        this.state=pos.toString();
        this.comeFrom=state;
    }

    public int getCost()
    {
        int x=Integer.parseInt( comeFrom.state.substring(1,comeFrom.state.indexOf(",")));
        int y= Integer.parseInt(comeFrom.state.substring(comeFrom.state.indexOf(",")+1,comeFrom.state.length()-1));

        if ((x==pos.getRowIndex()-1&&y==pos.getColumnIndex()-1)||(x==pos.getRowIndex()+1&&y==pos.getColumnIndex()+1)||(x==pos.getRowIndex()+1&&y==pos.getColumnIndex()-1)||(x==pos.getRowIndex()-1&&y==pos.getColumnIndex()+1))
            cost=15;
        else
            cost=10;
        return cost;
    }

    public int getX()
    {
        return pos.getRowIndex();
    }

    public int getY()
    {
        return pos.getColumnIndex();
    }
}
