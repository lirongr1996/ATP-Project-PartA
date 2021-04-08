package algorithms.Search;

import java.util.*;

public abstract class ASearchingAlgorithm implements  ISearchingAlgorithm{
    protected int countNode;


    /**
     * @param currentState is the goal of the maze
     * @param start the start postion of the maze
     * @return arrayList the contain path of the solution that found from the search algorithm
     */
    public ArrayList<AState> restoration (AState currentState, AState start)
    {
        if (currentState==null || start==null)
        {
            System.out.println("The state is null");
            System.exit(0);
        }
        ArrayList <AState> path=new ArrayList<>();
        while (currentState.state.compareTo((start.state))!=0)
        {
            path.add(currentState);
            currentState=currentState.getComeFrom();
        }
        path.add(currentState);
        return path;
    }
}
