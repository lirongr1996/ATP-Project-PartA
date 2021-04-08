package algorithms.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> possibleState ;

    public BreadthFirstSearch() {
        this.possibleState= new LinkedList<>();
    }

    public Queue<AState> getPossibleState() {
        return possibleState;
    }

    /**
     * @param domain the problem that need to be solved, like maze
     * @return ths solution to the problem
     */
    @Override
    public Solution solve(ISearchable domain) throws Exception {
        if (domain==null)
            throw new Exception("the domain is null");
        domain.clearVisit();
        Solution solve=new Solution();

        AState start=domain.getStartState();
        getPossibleState().add(start);

        countNode++;

        AState currentState=null;

        while (!getPossibleState().isEmpty())
        {
            currentState=getPossibleState().remove();

            if (currentState.state.compareTo(domain.getGoalState().state)==0)
                break;

            ArrayList<AState> neighbors=domain.getAllSuccessors(currentState);


            while(!neighbors.isEmpty()) {
                AState n=neighbors.remove(0);
                n.setComeFrom(currentState);
                getPossibleState().add(n);
                countNode++;
            }
        }
        solve.solutionPath=restoration(currentState,domain.getStartState());

        return solve;
    }

    /**
     * @return thee name of the search algorithm
     */
    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }

    /**
     * @return the number of the steps that took to solve the problem
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return countNode;
    }
}
