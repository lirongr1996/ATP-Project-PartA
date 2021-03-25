package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class prim extends AMazeGenerator {



    @Override
    public Maze generate(int row, int col) {
        Random rand=new Random();
        Maze m=new Maze(row,col);
        int [][] maze=m.getTwoDMaze();
        boolean [][]visit=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=1;
                visit[i][j]=false;
            }
        }

        boolean start=false,end=false;
        LinkedList<int[]> frontiers = new LinkedList<>();
        int x= rand.nextInt(row);
        int y=rand.nextInt(col);
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
                if ( x < row-2 && maze[x+2][y] == 1 )
                    frontiers.add( new int[]{x+1,y,x+2,y} );
                if ( y < col-2 && maze[x][y+2] == 1 )
                    frontiers.add( new int[]{x,y+1,x,y+2} );

                if (start==false && (x==0 || x==row-1 || y==0 || y==col-1)) {
                    m.setStart(new Position(x, y));
                    start=true;
                }
                else if (end==false && start==true && (x==0 || x==row-1 || y==0 || y==col-1)) {
                    if (m.getStartPosition().getRowIndex()==0 && x!=0 && m.getStartPosition().getColumnIndex()!=y) {
                        m.setGoal(new Position(x, y));
                        end = true;
                    }
                    else if (m.getStartPosition().getRowIndex()==row-1 && x!=row-1 && m.getStartPosition().getColumnIndex()!=y)
                    {
                        m.setGoal(new Position(x, y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==0 && y!=0 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position(x, y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==col-1 && y!=col-1 && m.getStartPosition().getRowIndex()!=x)
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
