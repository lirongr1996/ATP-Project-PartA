package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{


    /**
     * @param row is the number of the maze rows.
     * @param col is the number of the maze columns.
     * @return the maze that created
     */
    @Override
    public Maze generate(int row, int col) throws Exception {
        if (row<=0 || col<=0 || (row==1 && col==1))
            throw new Exception("the data of create maze is out of bounds");
        Random rand=new Random();
        Maze m=new Maze(row,col);
        int [][] maze=m.getTwoDMaze();
        //fill the maze with random numbers(0 or 1)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=rand.nextInt(2);
            }
        }
        //choose random start and goal positions
        int x=0,y, destination;
        int yS=rand.nextInt(col);
        m.setStart(new Position(0,yS));
        int yE=rand.nextInt(col);
        m.setGoal(new Position(row-1,yE));
        y=yS;
        //create  a path from the start position to the end position
        if (yS<=yE)
        {
            while (x<row-1 && y<yE)
            {
                destination=rand.nextInt(2);// 0-right, 1-down
                if (destination==0)
                {
                    maze[x][y+1]=0;
                    y++;
                }
                else
                {
                    maze[x+1][y]=0;
                    x++;
                }
            }
            while(x!=row-1)
            {
                maze[x+1][y]=0;
                x++;
            }
            while(y!=yE)
            {
                maze[x][y+1]=0;
                y++;
            }
        }
        else
        {
            while (x<row-1 && y>yE)
            {
                destination=rand.nextInt(2);// 0-left, 1-down
                if (destination==0)
                {
                    maze[x][y-1]=0;
                    y--;
                }
                else
                {
                    maze[x+1][y]=0;
                    x++;
                }
            }
            while(x!=row-1)
            {
                maze[x+1][y]=0;
                x++;
            }
            while(y!=yE)
            {
                maze[x][y-1]=0;
                y--;
            }
        }

        return  m;
    }
}
