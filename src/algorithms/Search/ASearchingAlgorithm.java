package algorithms.Search;

import java.util.*;

public abstract class ASearchingAlgorithm implements  ISearchingAlgorithm{
    protected int countNode;


    public ArrayList<AState> restoration (AState currentState, AState start)
    {
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
