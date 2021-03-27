package algorithms.Search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private MazeState startState;
    private MazeState goalState;

    public SearchableMaze (Maze maze)
    {
        this.maze=maze;
        startState=new MazeState(maze.getStartPosition(),null);
        goalState=new MazeState(maze.getGoalPosition(),null);
    }

    @Override
    public AState getStartState() {
        return startState;
    }

    @Override
    public AState getGoalState() {
        return goalState;
    }

    public ArrayList<AState> getAllPossibleStates (AState stateA)
    {
        MazeState state=(MazeState) stateA;
        int [][]m=this.maze.getTwoDMaze();
        ArrayList<AState> possibleStates=new ArrayList<>();

        if (state.getX()==0 &&state.getY()==0)
        {
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));

            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
        }
        else if (state.getX()==0&&state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));

            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));

        }
        else if (state.getX()==maze.getRow()-1 && state.getY()==0)
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()+1),state));
        }
        else if (state.getX()==maze.getRow()-1 && state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
        }
        else if (state.getX()==0)
        {
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));

            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
        }
        else if (state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
        }
        else if (state.getX()==maze.getRow()-1)
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()+1),state));
        }
        else if (state.getY()==0)
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));
            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()+1),state));

        }
        else
        {
            if (m[state.getX()-1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()),state));
            if (m[state.getX()+1][state.getY()]==0)
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()),state));
            if (m[state.getX()][state.getY()-1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()-1),state));
            if (m[state.getX()][state.getY()+1]==0)
                possibleStates.add(new MazeState(new Position(state.getX(),state.getY()+1),state));


            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0))
                possibleStates.add(new MazeState(new Position(state.getX()-1,state.getY()+1),state));

        }
        return possibleStates;
    }
}
