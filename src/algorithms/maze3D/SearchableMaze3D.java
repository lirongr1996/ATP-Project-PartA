package algorithms.maze3D;

import algorithms.Search.AState;
import algorithms.Search.ISearchable;
import algorithms.Search.MazeState;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {
    private Maze3D maze;
    private Maze3DState startState;
    private Maze3DState goalState;
    private boolean [][][] visit;

    public SearchableMaze3D (Maze3D maze) throws Exception {
        if (maze==null)
            throw new Exception("the maze is null");
        this.maze=maze;
        startState=new Maze3DState(maze.getStartPosition(),null);
        goalState=new Maze3DState(maze.getGoalPosition(),null);
        visit=new boolean[maze.getRow()][maze.getCol()][maze.getDepth()];
        for (int i = 0; i < maze.getDepth(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                for (int k = 0; k < maze.getCol(); k++) {
                    visit[j][k][i]=false;
                }
            }

        }
    }


    /**
     * @return the start position that the maze begin
     */
    @Override
    public AState getStartState() {
        return startState;
    }

    /**
     * @return the goal position of the maze
     */
    @Override
    public AState getGoalState() {
        return goalState;
    }

    /**
     * @param stateA is the state from the maze
     * @return arrayList that contains the all possible neighbor states that can move from stateA to them
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState stateA) throws Exception {
        if (stateA == null)
            throw new Exception("The state is null");
        Maze3DState state = (Maze3DState) stateA;
        int[][][] m = this.maze.getMap();
        ArrayList<AState> possibleStates = new ArrayList<>();

            if (state.getX() == 0 && state.getY() == 0 && state.getZ() == 0) {
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY() ), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
            }
            else if (state.getX() == maze.getRow() - 1 && state.getY() == maze.getCol() - 1 && state.getZ() == 0) {
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY() ), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == 0 && state.getY() == maze.getCol() - 1 && state.getZ() == 0) {
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY() ), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == maze.getRow() - 1 && state.getY() == 0 && state.getZ() == 0) {
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == 0 && state.getY() == 0 && state.getZ() == maze.getDepth() - 1) {
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
            }
            else if (state.getX() == maze.getRow() - 1 && state.getY() == maze.getCol() - 1 && state.getZ() == maze.getDepth() - 1) {
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == 0 && state.getY() == maze.getCol() - 1 && state.getZ() == maze.getDepth() - 1) {
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == maze.getRow() - 1 && state.getY() == 0 && state.getZ() == maze.getDepth() - 1) {
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == 0) {
                if (state.getZ() > 0 && m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (state.getZ() < maze.getDepth() - 1 && m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (state.getY()>0 &&m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (state.getY()<maze.getCol()-1 &&m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
            }
            else if (state.getX() == maze.getRow() - 1) {
                if (state.getZ() > 0 && m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (state.getZ() < maze.getDepth() - 1 && m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (state.getY()>0 &&m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (state.getY()<maze.getCol()-1&&m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
            }
            else if (state.getY() == 0) {
                if (state.getZ() > 0 && m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (state.getZ() < maze.getDepth() - 1 && m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (state.getX()>0&&m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (state.getX()<maze.getRow()-1&&m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
            }
            else if (state.getY() == maze.getCol() - 1) {
                if (state.getZ() > 0 && m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (state.getZ() < maze.getDepth() - 1 && m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (state.getX()>0&&m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (state.getX()<maze.getRow()-1&&m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
            }
            else if (state.getZ() == 0) {
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (state.getY()<maze.getCol()-1&&m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
                if (state.getX()>0&&m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (state.getY()>0&&m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (state.getX()<maze.getRow()-1&&m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
            }
            else if (state.getZ() == maze.getDepth() - 1) {
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (state.getY()<maze.getCol()-1&&m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
                if (state.getX()>0&&m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (state.getY()>0&&m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (state.getX()<maze.getRow()-1&&m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY() ), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
            }
            else {
                if (m[state.getX()][state.getY()][state.getZ() - 1] == 0 && visit[state.getX()][state.getY()][state.getZ() - 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() - 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() - 1] = true;
                }
                if (m[state.getX()][state.getY()][state.getZ() + 1] == 0 && visit[state.getX()][state.getY()][state.getZ() + 1] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ() + 1,state.getX(), state.getY()), state));
                    visit[state.getX()][state.getY()][state.getZ() + 1] = true;
                }
                if (m[state.getX()][state.getY() + 1][state.getZ()] == 0 && visit[state.getX()][state.getY() + 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX(), state.getY() + 1), state));
                    visit[state.getX()][state.getY() + 1][state.getZ()] = true;
                }
                if (m[state.getX() - 1][state.getY()][state.getZ()] == 0 && visit[state.getX() - 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() - 1, state.getY()), state));
                    visit[state.getX() - 1][state.getY()][state.getZ()] = true;
                }
                if (m[state.getX()][state.getY() - 1][state.getZ()] == 0 && visit[state.getX()][state.getY() - 1][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D( state.getZ(),state.getX(), state.getY() - 1), state));
                    visit[state.getX()][state.getY() - 1][state.getZ()] = true;
                }
                if (m[state.getX() + 1][state.getY()][state.getZ()] == 0 && visit[state.getX() + 1][state.getY()][state.getZ()] == false) {
                    possibleStates.add(new Maze3DState(new Position3D(state.getZ(),state.getX() + 1, state.getY()), state));
                    visit[state.getX() + 1][state.getY()][state.getZ()] = true;
                }
            }

            return possibleStates;


    }


    /**
     * the function change the value of all the cells in array to false in order to search again the maze
     */
    @Override
    public void clearVisit() {
        for (int i = 0; i < maze.getDepth(); i++) {
            for (int j = 0; j < maze.getRow(); j++) {
                for (int k = 0; k < maze.getCol(); k++) {
                    visit[j][k][i]=false;
                }
            }
        }
    }
}
