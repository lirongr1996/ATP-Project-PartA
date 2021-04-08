package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator{

    /**
     * @param depth is the number of the depth of the maze
     * @param row is the number of the row of the maze
     * @param column is the number of the column of the maze
     * @return the maze the created
     */
    public Maze3D generate(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0 || (row==1 && column==1))
            throw new Exception("the data of create maze is negative");
        Maze3D maze=new Maze3D(depth,row,column);
        while (maze.getStartPosition()==null ||maze.getGoalPosition()==null) {
            generate(maze);
        }

        return maze;
    }

    /**
     * @param m is the maze that created, that fill with prim algorithm
     * visit is boolean array, if the cell is visited- true, else- false
     * frontiers is list that contains the possible cells to change to 0
     * if start or the end is false, and the position is in the bounds, so set the start/goal position
     */
    private void generate(Maze3D m) throws Exception {
        if (m==null)
            throw new Exception("The maze is null");
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
            int[] f = frontiers.remove(  );
            x = f[3];
            y = f[4];
            z =  f[5];

            if (maze[x][y][z]==1)
            {
                maze[f[0]][f[1]][f[2]]=0;
                maze[x][y][z]=0;
                if ( x >= 2 && maze[x-2][y][z] == 1 ) {
                    frontiers.add(new int[]{x - 1, y, z, x - 2, y, z});
                }
                if ( y >= 2 && maze[x][y-2][z] == 1  ) {
                    frontiers.add(new int[]{x, y - 1, z, x, y - 2, z});
                }
                if ( x < m.getRow()-2 && maze[x+2][y][z] == 1 ) {
                    frontiers.add(new int[]{x + 1, y, z, x + 2, y, z});
                }
                if ( y < m.getCol()-2 && maze[x][y+2][z] == 1) {
                    frontiers.add(new int[]{x, y + 1, z, x, y + 2, z});
                }

                if (z>=1 && maze[x][y][z-1] == 1 ) {
                    frontiers.add(new int[]{x, y, z - 1, x, y, z - 1});
                }
                if (z<m.getDepth()-1 && maze[x][y][z+1] == 1) {
                    frontiers.add(new int[]{x, y, z + 1, x, y, z + 1});
                }


                if (start==false && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1)) {
                    m.setStart(new Position3D(z,x,y));
                    start=true;
                }
                else if (end==false && start==true && (x==0 || x==m.getRow()-1 || y==0 || y==m.getCol()-1) && z!=m.getStartPosition().getDepthIndex()) {
                    if (m.getStartPosition().getRowIndex()==0 && x!=0 && m.getStartPosition().getColumnIndex()!=y) {
                        m.setGoal(new Position3D(z,x,y));
                        end = true;
                    }
                    else if (m.getStartPosition().getRowIndex()==m.getRow()-1 && x!=m.getRow()-1 && m.getStartPosition().getColumnIndex()!=y)
                    {
                        m.setGoal(new Position3D(z,x,y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==0 && y!=0 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position3D(z,x,y));
                        end=true;
                    }
                    else if (m.getStartPosition().getColumnIndex()==m.getCol()-1 && y!=m.getCol()-1 && m.getStartPosition().getRowIndex()!=x)
                    {
                        m.setGoal(new Position3D(z,x,y));
                        end=true;
                    }
                }
//                if (end==true)
//                    break;
            }
        }


//        while (!frontiers.isEmpty())
//        {
//            int[] f = frontiers.remove();
//            maze[f[0]][f[1]][f[2]]= rand.nextInt(2);
//            maze[f[3]][f[4]][f[5]]= rand.nextInt(2);
//        }
//        for (int i = 0; i <m.getDepth() ; i++) {
//            for (int j = 0; j <m.getRow(); j++) {
//                for (int k = 0; k < m.getCol(); k++) {
//                    if (visit[j][k][i]==false)
//                        maze[j][k][i]=rand.nextInt(2);
//                }
//            }
//        }

    }
}
