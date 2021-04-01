package algorithms.mazeGenerators;

public class Maze {
    private  int [][] twoDMaze;
    private Position start;
    private  Position goal;

    public Maze(int row, int col) {
        if (row<=0 || col<=0 || (row==1 && col==1))
            return;
        twoDMaze=new int[row][col];
    }

    public Position getStartPosition()
    {
        return  start;
    }

    public void setStart(Position start) {
        if (start==null)
            return;
        this.start = start;
    }

    public void setGoal(Position goal) {
        if (goal==null)
            return;
        this.goal = goal;
    }

    public  Position getGoalPosition()
    {
        return  goal;
    }

    public int[][] getTwoDMaze() {
        return twoDMaze;
    }

    public int getRow()
    {
        return twoDMaze.length;
    }
    public int getCol()
    {
        return twoDMaze[0].length;
    }

    public void setPosition (int row, int col, int k)
    {
        if (row<=0 || col<=0 || (row==1 && col==1)|| (k!=0 && k!=1))
            return;
        this.twoDMaze[row][col]=k;
    }


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
