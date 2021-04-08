package algorithms.mazeGenerators;

public interface IMazeGenerator {

    public  Maze generate (int row, int col) throws Exception;

    public long measureAlgorithmTimeMillis (int row, int col) throws Exception;
}
