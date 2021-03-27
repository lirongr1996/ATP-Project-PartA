package algorithms.Search;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch{
    PriorityQueue<AState>possibleState=new PriorityQueue<>(new cellsCostCompearator());

    @Override
    public String getName() {
        return "BestFirstSearch";
    }

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
            while(!neighbors.isEmpty()) {
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
}



class cellsCostCompearator implements Comparator<AState> {
    @Override
    public int compare(AState x, AState y) {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.getCost() < y.getCost()) {
            return 1;
        }
        if (x.getCost() > y.getCost()) {
            return -1;
        }
        return 0;
    }
}

