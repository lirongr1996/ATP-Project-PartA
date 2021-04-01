package algorithms.Search;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class DepthFirstSearch extends ASearchingAlgorithm{
    Stack<AState>possibleState=new Stack<>();



    @Override
    public Solution solve(ISearchable domain) {
        if (domain==null)
            return null;
        domain.clearVisit();
        Solution solve=new Solution();

        AState start=domain.getStartState();
        possibleState.push(start);

        countNode++;
        start.setVisit(true);

        AState currentState=null;
        while (!possibleState.empty())
        {
            currentState=possibleState.pop();

            if (currentState.state.compareTo(domain.getGoalState().state)==0)
                break;

            ArrayList <AState> neighbors=domain.getAllSuccessors(currentState);
            if (neighbors==null)
                continue;
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

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return countNode;
    }
}
