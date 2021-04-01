package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    private int [][][]threeDMaze;
    private Position3D start;
    private  Position3D goal;

    public Maze3D(int depth, int row, int column) {
        if (depth<=0 || row<=0 || column<=0 || (row==1 && column==1))
            return;
        this.threeDMaze =new int[row][column][depth];
    }

    public int[][][] getMap()
    {
        return this.threeDMaze;
    }
    public Position3D getStartPosition()
    {
        return this.start;
    }
    public Position3D getGoalPosition()
    {
        return this.goal;
    }

    public void setStart(Position3D start) {
        if (start==null)
            return;
        this.start = start;
    }

    public void setGoal(Position3D goal) {
        if (goal==null)
            return;
        this.goal = goal;
    }


    public int getRow()
    {
        return threeDMaze.length;
    }
    public int getCol()
    {
        return threeDMaze[0].length;
    }

    public int getDepth()
    {
        return this.threeDMaze[0][0].length;
    }

    public void setPosition (int row, int col, int depth, int k)
    {
        if (depth<=0 || row<=0 || col<=0 || (row==1 && col==1) || (k!=1 && k!=0))
            return;
        this.threeDMaze[row][col][depth]=k;
    }


    public void print()
    {
        int count=2*threeDMaze[0].length+2;
        System.out.println("{ ");
        for (int i = 0; i < threeDMaze[0][0].length; i++) {
            for (int j = 0; j < threeDMaze.length; j++) {
                System.out.print("{ ");
                for (int k = 0; k < threeDMaze[0].length; k++) {
                    if(j==getStartPosition().getRowIndex()&&k==getStartPosition().getColumnIndex() && i==getStartPosition().getDepthIndex())
                        System.out.print("S ");
                    else if(j==getGoalPosition().getRowIndex()&&k==getGoalPosition().getColumnIndex() && i==getGoalPosition().getDepthIndex())
                        System.out.print("E ");
                    else
                        System.out.print(threeDMaze[j][k][i]+" ");
                }
                System.out.println("}");
            }
            for (int k = 0; k <count &&i!=threeDMaze[0][0].length-1; k++) {
                System.out.print("-");
            }
            if (i!=threeDMaze[0][0].length-1)
                System.out.println();
        }
        System.out.println("}");
    }
}
