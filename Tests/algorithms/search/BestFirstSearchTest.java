package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void getName() {
        BestFirstSearch bfs=new BestFirstSearch();
        assertEquals("BestFirstSearch", bfs.getName());
    }

    @Test
    void solve() {
        try {
        BestFirstSearch bfs=new BestFirstSearch();
        Maze m=new Maze(4,4);
        int [][]maze=m.getTwoDMaze();
        maze[0][0]=0;
        maze[0][1]=0;
        maze[0][2]=1;
        maze[0][3]=1;
        maze[1][0]=0;
        maze[1][1]=0;
        maze[1][2]=0;
        maze[1][3]=0;
        maze[2][0]=0;
        maze[2][1]=1;
        maze[2][2]=0;
        maze[2][3]=1;
        maze[3][0]=0;
        maze[3][1]=0;
        maze[3][2]=0;
        maze[3][3]=1;
        m.setStart(new Position(0,0));
        m.setGoal(new Position(1,3));
        SearchableMaze searchableMaze = new SearchableMaze(m);
        ArrayList<AState>result=new ArrayList<>();
        MazeState m1=new MazeState(new Position(0,0),null);
        MazeState m2=new MazeState(new Position(0,1),m1);
        MazeState m3=new MazeState(new Position(1,2),m2);
        MazeState m4=new MazeState(new Position(1,3),m3);
        result.add(m1);
        result.add(m2);
        result.add(m3);
        result.add(m4);
        ArrayList <AState>solution= null;

            solution = bfs.solve(searchableMaze).getSolutionPath();
            assertArrayEquals(result.toArray(),solution.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}