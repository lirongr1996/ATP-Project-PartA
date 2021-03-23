package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {



    @Override
    public Maze generate(int row, int col) {
        Maze m=new Maze(row,col);
        int [][] maze=m.getTwoDMaze();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j]=0;
            }
        }
        return  m;
    }
}
