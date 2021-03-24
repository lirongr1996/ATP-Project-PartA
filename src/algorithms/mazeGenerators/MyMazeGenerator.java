package algorithms.mazeGenerators;

import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {


    /**
     * @param row is the number of rows
     * @param col is the number of columns
     * neighborCell: 0=up cell, 1=right cell, 2= down cell, 3= left cell
     * visitedCells is the number of cells we visited
     *
     * @return
     */
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

        int visitedCells=1, dx=0, dy=0;
        int x= rand.nextInt(row);
        int y=rand.nextInt(col);
        int neighborCell=rand.nextInt(4);

        maze[x][y]=0;

        while (visitedCells< row*col/2)
        {
            if (neighborCell==0)
            {
                dx=-2;
                dy=0;

                if (x-2>=0)
                {
                    if (visit[x-2][y]==false)
                    {
                        maze[x-1][y]=0;
                        maze[x-2][y]=0;
                        visit[x-2][y]=true;
                        visit[x-1][y]=true;
                        visitedCells+=2;
                    }
                }
                else if (x-1==0)
                {
                    dx=-1;
                    maze[x-1][y]=0;
                    visit[x-1][y]=true;
                    visitedCells+=1;
                }
            }
            if (neighborCell==1)
            {
                dx=0;
                dy=2;

                if (y+2<col)
                {
                    if (visit[x][y+2]==false)
                    {
                        maze[x][y+1]=0;
                        maze[x][y+2]=0;
                        visit[x][y+2]=true;
                        visit[x][y+1]=true;
                        visitedCells+=2;
                    }
                }
                else if (y+1==col-1)
                {
                    dy=1;
                    maze[x][y+1]=0;
                    visit[x][y+1]=true;
                    visitedCells+=1;
                }
            }
            if (neighborCell==2)
            {
                dx=2;
                dy=0;

                if (x+2<row)
                {
                    if(visit [x+2][y]==false)
                    {
                        maze[x+1][y]=0;
                        maze[x+2][y]=0;
                        visit [x+2][y]=true;
                        visit [x+1][y]=true;
                        visitedCells+=2;
                    }
                }
                else if (x+1==row-1)
                {
                    dx=1;
                    maze[x+1][y]=0;
                    visit [x+1][y]=true;
                    visitedCells+=1;
                }
            }
            if ( neighborCell==3)
            {
                dx=0;
                dy=-2;

                if (y-2>=0)
                {
                    if (visit[x][y-2]==false)
                    {
                        maze[x][y-1]=0;
                        maze[x][y-2]=0;
                        visit[x][y-2]=true;
                        visit[x][y-1]=true;
                        visitedCells+=2;
                    }
                }
                else if (y-1==0)
                {
                    dy=-1;
                    maze[x][y-1]=0;
                    visit[x][y-1]=true;
                    visitedCells+=1;
                }
            }

            neighborCell=rand.nextInt(4);

            if (x+dx>=0&& x+dx<row && y+dy>=0 && y+dy<col)
            {
                x+=dx;
                y+=dy;
            }
        }
        return m;
    }
}
