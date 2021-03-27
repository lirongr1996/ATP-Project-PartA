package algorithms.Search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    protected Queue<AState> possibleState = new LinkedList<>();

    @Override
    public Solution solve(ISearchable domain) {
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
            for (int i = 0; i < neighbors.size(); i++) {
                AState n=neighbors.remove(0);
                n.setVisit(true);
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