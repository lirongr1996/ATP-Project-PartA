package algorithms.Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> possibleState = new LinkedList<>();

    @Override
    public Solution solve(ISearchable domain) {
        domain.clearVisit();
        Solution solve=new Solution();

        AState start=domain.getStartState();
        possibleState.add(start);

        countNode++;
        start.setVisit(true);

        AState currentState=null;

        while (!possibleState.isEmpty())
        {
            currentState=possibleState.remove();

            if (currentState.state.compareTo(domain.getGoalState().state)==0)
                break;

            ArrayList<AState> neighbors=domain.getAllPossibleStates(currentState);

            while(!neighbors.isEmpty()) {
                AState n=neighbors.remove(0);
                n.setComeFrom(currentState);
                possibleState.add(n);
                countNode++;
            }
        }
        solve.solutionPath=restoration(currentState,domain.getStartState());

        return solve;
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return countNode;
    }
}
