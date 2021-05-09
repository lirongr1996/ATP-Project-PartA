package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchableMaze implements ISearchable, Serializable {
    private Maze maze;
    private MazeState startState;
    private MazeState goalState;
    private boolean [][] visit; //visit is the matrix of visited cells.

    public SearchableMaze (Maze maze) throws Exception {
        this.maze=maze;
        startState=new MazeState(maze.getStartPosition(),null);
        goalState=new MazeState(maze.getGoalPosition(),null);
        visit=new boolean[maze.getRow()][maze.getCol()];
        for (int i = 0; i < maze.getRow(); i++) {
            for (int j = 0; j < maze.getCol(); j++) {
                visit[i][j]=false;
            }

        }
    }

    /**
     * the function change the value of all the cells in array to false in order to search again the maze
     */
    public void clearVisit()
    {
        for (int i = 0; i < maze.getRow(); i++) {
            for (int j = 0; j < maze.getCol(); j++) {
                visit[i][j]=false;
            }
        }
    }

    /**
     * @return the start state in the maze
     */
    @Override
    public AState getStartState() {
        return startState;
    }

    /**
     * @return the goal state in the maze
     */
    @Override
    public AState getGoalState() {
        return goalState;
    }

    /**
     * @param stateA is a state in the maze
     * @return arrayList that contains the all possible neighbors states that can move from stateA to them
     */
    public ArrayList<AState> getAllSuccessors (AState stateA) throws Exception {
        if (stateA==null)
            throw new Exception("the state is null");
        MazeState state=(MazeState) stateA;
        int [][]m=this.maze.getTwoDMaze();
        ArrayList<AState> possibleStates=new ArrayList<>();

        if (state.getX()==0 &&state.getY()==0)
        {
            if (m[state.getX()+1][state.getY()]==0&& visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()+1]==0&&visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }

            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0) && visit[state.getX()+1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() + 1), state));
                visit[state.getX()+1][state.getY()+1]=true;
            }
        }
        else if (state.getX()==0&&state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()+1][state.getY()]==0 &&visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0&&visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }

            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0)&& visit[state.getX()+1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() - 1), state));
                visit[state.getX()+1][state.getY()-1]=true;
            }

        }
        else if (state.getX()==maze.getRow()-1 && state.getY()==0)
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()+1]==0 && visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0)&& visit[state.getX()-1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() + 1), state));
                visit[state.getX()-1][state.getY()+1]=true;
            }
        }
        else if (state.getX()==maze.getRow()-1 && state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0 &&visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0)&& visit[state.getX()-1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() - 1), state));
                visit[state.getX()-1][state.getY()-1]=true;
            }
        }
        else if (state.getX()==0)
        {
            if (m[state.getX()+1][state.getY()]==0 &&visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0 && visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }
            if (m[state.getX()][state.getY()+1]==0 &&visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }

            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0)&& visit[state.getX()+1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() + 1), state));
                visit[state.getX()+1][state.getY()+1]=true;
            }
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0) && visit[state.getX()+1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() - 1), state));
                visit[state.getX()+1][state.getY()-1]=true;
            }
        }
        else if (state.getY()==maze.getCol()-1)
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()+1][state.getY()]==0 && visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0 && visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0) && visit[state.getX()+1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() - 1), state));
                visit[state.getX()+1][state.getY()-1]=true;
            }
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0)&& visit[state.getX()-1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() - 1), state));
                visit[state.getX()-1][state.getY()-1]=true;
            }
        }
        else if (state.getX()==maze.getRow()-1)
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0 && visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }
            if (m[state.getX()][state.getY()+1]==0&& visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0) && visit[state.getX()-1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() - 1), state));
                visit[state.getX()-1][state.getY()-1]=true;
            }
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0) && visit[state.getX()-1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() + 1), state));
                visit[state.getX()-1][state.getY()+1]=true;
            }
        }
        else if (state.getY()==0)
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()+1][state.getY()]==0 && visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()+1]==0&& visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }
            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0) && visit[state.getX()+1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() + 1), state));
                visit[state.getX()+1][state.getY()+1]=true;
            }
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0) && visit[state.getX()-1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() + 1), state));
                visit[state.getX()-1][state.getY()+1]=true;
            }

        }
        else
        {
            if (m[state.getX()-1][state.getY()]==0 && visit[state.getX()-1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY()), state));
                visit[state.getX()-1][state.getY()]=true;
            }
            if (m[state.getX()+1][state.getY()]==0 && visit[state.getX()+1][state.getY()]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY()), state));
                visit[state.getX()+1][state.getY()]=true;
            }
            if (m[state.getX()][state.getY()-1]==0 && visit[state.getX()][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() - 1), state));
                visit[state.getX()][state.getY()-1]=true;
            }
            if (m[state.getX()][state.getY()+1]==0 && visit[state.getX()][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX(), state.getY() + 1), state));
                visit[state.getX()][state.getY()+1]=true;
            }


            if (m[state.getX()+1][state.getY()+1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0) && visit[state.getX()+1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() + 1), state));
                visit[state.getX()+1][state.getY()+1]=true;
            }
            if (m[state.getX()+1][state.getY()-1]==0 && (m[state.getX()+1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0) && visit[state.getX()+1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() + 1, state.getY() - 1), state));
                visit[state.getX()+1][state.getY()-1]=true;
            }
            if (m[state.getX()-1][state.getY()-1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()-1]==0) && visit[state.getX()-1][state.getY()-1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() - 1), state));
                visit[state.getX()-1][state.getY()-1]=true;
            }
            if (m[state.getX()-1][state.getY()+1]==0 && (m[state.getX()-1][state.getY()]==0 || m[state.getX()][state.getY()+1]==0)&& visit[state.getX()-1][state.getY()+1]==false) {
                possibleStates.add(new MazeState(new Position(state.getX() - 1, state.getY() + 1), state));
                visit[state.getX()-1][state.getY()+1]=true;
            }

        }
        return possibleStates;
    }
}
