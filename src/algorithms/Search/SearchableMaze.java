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

    public ArrayList<AState> getAllPossibleStates (MazeState state)
    {
        int [][]m=this.maze.getTwoDMaze();
        ArrayList<AState> possibleStates=new ArrayList<>();

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
            possibleStates.add(new MazeState(new Position(state.getX()+1,state.getY()+1),state));

        return possibleStates;
    }
}
