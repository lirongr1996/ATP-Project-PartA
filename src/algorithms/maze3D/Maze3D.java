package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {
    private int [][][]threeDMaze;
    private Position3D start;
    private  Position3D goal;

    public Maze3D(int depth, int row, int column) throws Exception {
        if (depth<2 || row<0 || column<0)
            throw new Exception("the data of create maze is out of bounds");
        this.threeDMaze =new int[row][column][depth];
    }

    /**
     * @return the 3D array that contain the maze
     */
    public int[][][] getMap()
    {
        return this.threeDMaze;
    }

    /**
     * @return the start position of the maze
     */
    public Position3D getStartPosition()
    {
        return this.start;
    }

    /**
     * @return the goal position
     */
    public Position3D getGoalPosition()
    {
        return this.goal;
    }

    /**
     * @param start is the position where the maze begin
     */
    public void setStart(Position3D start) throws Exception {
        if (start==null)
            throw new Exception("the start position is null");
        this.start = start;
    }

    /**
     * @param goal is the position where the maze ends
     */
    public void setGoal(Position3D goal) throws Exception {
        if (goal==null)
            throw new Exception("the goal position is null");
        this.goal = goal;
    }


    /**
     * @return the number of the rows in the maze
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
     * @param row is row number in the position
     * @param col is columns number in the position
     * @param depth is depths number in the position
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
        System.out.println("{");
        for(int depth = 0; depth < getDepth(); depth++){
            for(int row = 0; row < getRow(); row++) {
                System.out.print("{ ");
                for (int col = 0; col < getCol(); col++) {
                    if (depth == start.getDepthIndex() && row == start.getRowIndex() && col == start.getColumnIndex()) // if the position is the start - mark with S
                        System.out.print("S ");
                    else {
                        if (depth == goal.getDepthIndex() && row == goal.getRowIndex() && col == goal.getColumnIndex()) // if the position is the goal - mark with E
                            System.out.print("E ");
                        else
                            System.out.print(threeDMaze[row][col][depth] + " ");
                    }
                }
                System.out.println("}");
            }
            if(depth < threeDMaze.length - 1) {
                System.out.print("---");
                for (int i = 0; i < threeDMaze[0][0].length; i++)
                    System.out.print("--");
                System.out.println();
            }
        }
        System.out.println("}");
    }
}
