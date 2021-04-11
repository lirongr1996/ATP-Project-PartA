package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {

    /**
     * @param row is the number of the maze rows.
     * @param col is the number of the maze column.
     * This function insures that the created maze is valid.
     * @return the maze that created
     */
    public Maze generate(int row, int col) throws Exception {
        if (row<=0 || col<=0 || (row==1 && col==1))
            throw new Exception("the data of create maze is out of bounds");
        Maze m=new Maze(row,col);
        while (m.getStartPosition()==null ||m.getGoalPosition()==null) {
            generate(m);
        }
        return m;
    }


    /**
     * @param m is the maze filled by this function with prim algorithm
     * frontiers is list that contains the possible neighbors
     * @return the maze that filled
     */
    public Maze generate(Maze m) throws Exception {
        if (m==null)
            throw new Exception("The maze is null");
        Random rand=new Random();
        int [][] maze=m.getTwoDMaze();
        //fill the maze with walls
        for (int i = 0; i < m.getRow(); i++) {
            for (int j = 0; j < m.getCol(); j++) {
                maze[i][j]=1;
            }
        }

        boolean start=false;
        LinkedList<int[]> frontiers = new LinkedList<>();
        int x,y;
        if (m.getRow()%2==0&&m.getCol()%2==0)
        {
            x=0;
            y=0;
            frontiers.add(new int[]{x,y,x+1,y});
        }
        else {
            x = rand.nextInt(m.getRow());
            y = rand.nextInt(m.getCol());
            frontiers.add(new int[]{x, y, x, y});
        }

        //implement the prim algorithm
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
                    if (m.getRow()%2==0&&m.getCol()%2==0)
                        m.setStart(new Position(0,0));
                    else
                        m.setStart(new Position(x, y));
                    start=true;
                }
                else if ( start==true && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    if (m.getStartPosition().getRowIndex()==0 && x!=0 && m.getStartPosition().getColumnIndex()!=y) {
                        m.setGoal(new Position(x, y));
                    }
                    else if (m.getStartPosition().getRowIndex()==m.getRow()-1 && x!=m.getRow()-1 && m.getStartPosition().getColumnIndex()!=y)
                    {
                        m.setGoal(new Position(x, y));
                    }
                    else if (m.getStartPosition().getColumnIndex()==0 && y!=0 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position(x, y));
                    }
                    else if (m.getStartPosition().getColumnIndex()==m.getCol()-1 && y!=m.getCol()-1 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position(x, y));
                    }
                }
            }
        }

        if (m.getRow()%2==0&& m.getCol()%2==0)
        {
            for (int i = 0; i < m.getCol(); i++) {
                maze[0][i]=rand.nextInt(2);
            }
            for (int i = 0; i < m.getRow(); i++) {
                maze[i][m.getCol()-1]=rand.nextInt(2);
            }
        }

        return m;
    }
}
