package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    private int [][][]threeDMaze;
    private Position3D start;
    private  Position3D goal;

    public Maze3D(int depth, int row, int column) throws Exception {
        if (depth<0 || row<0 || column<0 || (row==1 && column==1&& depth==1))
            throw new Exception("the data of create maze is negative");
        this.threeDMaze =new int[row][column][depth];
    }

    /**
     * @return the fubction return the array the contain the maze
     */
    public int[][][] getMap()
    {
        return this.threeDMaze;
    }

    /**
     * @return the function return the start position
     */
    public Position3D getStartPosition()
    {
        return this.start;
    }

    /**
     * @return the function return the goal position
     */
    public Position3D getGoalPosition()
    {
        return this.goal;
    }

    /**
     * @param start is the position of the start the maze begin
     */
    public void setStart(Position3D start) throws Exception {
        if (start==null)
            throw new Exception("the start position is null");
        this.start = start;
    }

    /**
     * @param goal is the position of the goal of the maze
     */
    public void setGoal(Position3D goal) throws Exception {
        if (goal==null)
            throw new Exception("the goal position is null");
        this.goal = goal;
    }


    /**
     * @return the number of the rows of the maze
     */
    public int getRow()
    {
        return threeDMaze.length;
    }

    /**
     * @return the number of the columns of the maze
     */
    public int getCol()
    {
        return threeDMaze[0].length;
    }

    /**
     * @return the number of the depth of the maze
     */
    public int getDepth()
    {
        return this.threeDMaze[0][0].length;
    }

    /**
     * @param row is the number of the row of the position
     * @param col is the number of the columns of the position
     * @param depth is the number of the depth of the position
     * @param k is value of the position
     */
    public void setPosition (int row, int col, int depth, int k) throws Exception {
        if (depth<=0 || row<=0 || col<=0 || (row==1 && col==1) || (k!=1 && k!=0))
            throw new Exception("The position is out of the bounds");
        this.threeDMaze[row][col][depth]=k;
    }


    /**
     * the function print the maze
     */
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
