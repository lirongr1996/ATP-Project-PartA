package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

import java.util.LinkedList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator{

    public Maze3D generate(int depth, int row, int column)
    {
        Maze3D maze=new Maze3D(depth,row,column);
        while (maze.getStartPosition()==null ||maze.getGoalPosition()==null) {
            generate(maze);
        }

        return maze;
    }

    private void generate(Maze3D m) {
        Random rand=new Random();
        int [][][] maze=m.getMap();
        boolean [][][]visit=new boolean[m.getRow()][m.getCol()][m.getDepth()];
        for (int i = 0; i < m.getDepth(); i++) {
            for (int j = 0; j < m.getRow(); j++) {
                for (int k = 0; k < m.getCol(); k++) {
                    maze[j][k][i]=1;
                    visit[j][k][i]=false;
                }

            }
        }

        boolean start=false,end=false;
        LinkedList<int[]> frontiers = new LinkedList<>();
        int x= rand.nextInt(m.getRow());
        int y=rand.nextInt(m.getCol());
        int z=rand.nextInt(m.getDepth());
        frontiers.add(new int[]{x,y,z,x,y,z});

        while (!frontiers.isEmpty())
        {
            int[] f = frontiers.remove( rand.nextInt( frontiers.size() ) );
            x = f[3];
            y = f[4];
            z =  f[5];
            if (maze[x][y][z]==1)
            {
                maze[f[0]][f[1]][f[2]]=0;
                maze[x][y][z]=0;
                if ( x >= 2 && maze[x-2][y][z] == 1 )
                    frontiers.add( new int[]{x-1,y,z,x-2,y,z} );
                if ( y >= 2 && maze[x][y-2][z] == 1 )
                    frontiers.add( new int[]{x,y-1,z,x,y-2,z} );
                if ( x < m.getRow()-2 && maze[x+2][y][z] == 1 )
                    frontiers.add( new int[]{x+1,y,z,x+2,y,z} );
                if ( y < m.getCol()-2 && maze[x][y+2][z] == 1 )
                    frontiers.add( new int[]{x,y+1,z,x,y+2,z} );

                if (z>0 && maze[x][y][z-1] == 1)
                    frontiers.add( new int[]{x,y,z-1,x,y,z-1} );
                if (z<m.getDepth()-1 && maze[x][y][z+1] == 1)
                    frontiers.add( new int[]{x,y,z+1,x,y,z+1} );


                if (start==false && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    m.setStart(new Position3D(x,y,z));
                    start=true;
                }
                else if (end==false && start==true && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    if (m.getStartPosition().getRowIndex()==0 && x!=0 && m.getStartPosition().getColumnIndex()!=y) {
                        m.setGoal(new Position3D(x,y,z));
                        end = true;
                    }
                    else if (m.getStartPosition().getRowIndex()==m.getRow()-1 && x!=m.getRow()-1 && m.getStartPosition().getColumnIndex()!=y)
                    {
                        m.setGoal(new Position3D(x,y,z));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==0 && y!=0 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position3D(x,y,z));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==m.getCol()-1 && y!=m.getCol()-1 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position3D(x,y,z));
                        end=true;
                    }
                }
            }
        }
    }
}
