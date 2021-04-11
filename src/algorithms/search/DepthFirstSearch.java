package algorithms.search;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState>possibleState;

    public DepthFirstSearch() {
        this.possibleState =new Stack<>();
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
        possibleState.push(start);

        countNode++;

        AState currentState=null;
        while (!possibleState.empty())
        {
            currentState=possibleState.pop();

            if (currentState.state.compareTo(domain.getGoalState().state)==0)
                break;

            ArrayList <AState> neighbors=domain.getAllSuccessors(currentState);
            Collections.shuffle(neighbors);
            while(!neighbors.isEmpty()) {
                AState n=neighbors.remove(0);
                n.setComeFrom(currentState);
                possibleState.push(n);
                countNode++;
            }
        }

        solve.solutionPath=restoration(currentState,domain.getStartState());

        return solve;
    }

    /**
     * @return the name of the searching algorithm
     */
    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    /**
     * @return the number of the steps that took to solve the problem
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return countNode;
    }
}
