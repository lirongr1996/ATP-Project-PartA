package algorithms.mazeGenerators;

public class Maze {
    private  int [][] twoDMaze;
    private Position start;
    private  Position goal;

    public Maze(int row, int col) throws Exception {
        if (row<0 || col<0 || (row==1 && col==1))
            throw new Exception("the data of create maze is out of bounds");
        twoDMaze=new int[row][col];
    }

    /**
     * @return the start position of the maze
     */
    public Position getStartPosition()
    {
        return  start;
    }

    /**
     * @param start is the position where the maze begin
     */
    public void setStart(Position start) throws Exception {
        if (start==null)
            throw new Exception("the start position is null");
        this.start = start;
    }

    /**
     * @param goal is the position where the maze ends
     */
    public void setGoal(Position goal) throws Exception {
        if (goal==null)
            throw new Exception("The goal position is null");
        this.goal = goal;
    }

    /**
     * @return the position of in maze goal
     */
    public  Position getGoalPosition()
    {
        return  goal;
    }

    /**
     * @return the matrix of the maze
     */
    public int[][] getTwoDMaze() {
        return twoDMaze;
    }

    /**
     * @return the number of the rows in the maze
     */
    public int getRow()
    {
        return twoDMaze.length;
    }

    /**
     * @return the number of the columns in the maze
     */
    public int getCol()
    {
        return twoDMaze[0].length;
    }

    /**
     * @param row is row number in the position
     * @param col is columns number in the position
     * @param k is value of the position
     */
    public void setPosition (int row, int col, int k) throws Exception {
        if (row<0 || col<0)
            throw new Exception("Can't change the value of the position because the negative data");
        this.twoDMaze[row][col]=k;
    }


    /**
     * the function print the maze
     */
    public void print()
    {
        for (int i = 0; i < twoDMaze.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < twoDMaze[0].length; j++) {
                if(i==getStartPosition().getRowIndex()&&j==getStartPosition().getColumnIndex())
                    System.out.print("S ");
                else if(i==getGoalPosition().getRowIndex()&&j==getGoalPosition().getColumnIndex())
                    System.out.print("E ");
                else
                    System.out.print(twoDMaze[i][j]+" ");
            }
            System.out.println("}");
        }
    }

}
