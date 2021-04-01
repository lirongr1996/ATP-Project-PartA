package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    public Maze generate(int row, int col) {
        if (row<=0 || col<=0 || (row==1 && col==1))
            return null;
        Maze m=new Maze(row,col);
        while (m.getStartPosition()==null ||m.getGoalPosition()==null) {
            generate(m);
        }
        return m;
    }


    /**
     * @param m is the maze
     * neighborCell: 0=up cell, 1=right cell, 2= down cell, 3= left cell
     * visitedCells is the number of cells we visited
     *
     * @return
     */
    public Maze generate(Maze m) {
        if (m==null)
            return  null;
        Random rand=new Random();
      //  Maze m=new Maze(row,col);
        int [][] maze=m.getTwoDMaze();
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getCol(); j++) {
                maze[i][j]=1;
            }
        }

        boolean start=false,end=false;
        LinkedList<int[]> frontiers = new LinkedList<>();
        int x= rand.nextInt(m.getRow());
        int y=rand.nextInt(m.getCol());
        frontiers.add(new int[]{x,y,x,y});

        while (!frontiers.isEmpty())
        {
            int[] f = frontiers.remove( rand.nextInt( frontiers.size() ) );
            x = f[2];
            y = f[3];
            if (maze[x][y]==1)
            {
                maze[f[0]][f[1]]=0;
                maze[x][y]=0;
                if ( x >= 2 && maze[x-2][y] == 1 )
                    frontiers.add( new int[]{x-1,y,x-2,y} );
                if ( y >= 2 && maze[x][y-2] == 1 )
                    frontiers.add( new int[]{x,y-1,x,y-2} );
                if ( x < m.getRow()-2 && maze[x+2][y] == 1 )
                    frontiers.add( new int[]{x+1,y,x+2,y} );
                if ( y < m.getCol()-2 && maze[x][y+2] == 1 )
                    frontiers.add( new int[]{x,y+1,x,y+2} );

                if (start==false && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    m.setStart(new Position(x, y));
                    start=true;
                }
                else if (end==false && start==true && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    if (m.getStartPosition().getRowIndex()==0 && x!=0 && m.getStartPosition().getColumnIndex()!=y) {
                        m.setGoal(new Position(x, y));
                        end = true;
                    }
                    else if (m.getStartPosition().getRowIndex()==m.getRow()-1 && x!=m.getRow()-1 && m.getStartPosition().getColumnIndex()!=y)
                    {
                        m.setGoal(new Position(x, y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==0 && y!=0 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position(x, y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==m.getCol()-1 && y!=m.getCol()-1 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position(x, y));
                        end=true;
                    }
                }
            }
        }


        return m;
    }
}
