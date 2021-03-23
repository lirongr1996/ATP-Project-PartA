package algorithms.mazeGenerators;

public class Maze {
    private  int [][] twoDMaze;

    public Maze(int row, int col) {
        twoDMaze=new int[row][col];
    }

    public Position getStartPosition()
    {
        return  new Position(0,0);
    }

    public  Position getGoalPosition()
    {
        return  new Position(0,0);
    }

    public int[][] getTwoDMaze() {
        return twoDMaze;
    }

    public void setPosition (int row, int col, int k)
    {
        this.twoDMaze[row][col]=k;
    }


    public void print()
    {
        for (int i = 0; i < twoDMaze.length; i++) {
            for (int j = 0; j < twoDMaze[0].length; j++) {
                if(i==getStartPosition().getRowIndex()&&j==getStartPosition().getColumnIndex())
                    System.out.print("S");
                else if(i==getGoalPosition().getRowIndex()&&j==getGoalPosition().getColumnIndex())
                    System.out.print("E");
                else
                    System.out.print(twoDMaze[i][j]);
            }
            System.out.println();
        }
    }

}
