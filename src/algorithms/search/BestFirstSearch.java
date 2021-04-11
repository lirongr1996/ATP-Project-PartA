package algorithms.search;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class BestFirstSearch extends BreadthFirstSearch {
    private Queue<AState> possibleState;

    public BestFirstSearch() {
        this.possibleState = new PriorityQueue<>(new cellsCostCompearator());
    }

    public Queue<AState> getPossibleState() {
        return possibleState;
    }

    /**
     * @return the name of the searching algorithm
     */
    @Override
    public String getName() {
        return "BestFirstSearch";
    }
}


/**
 * the compare class of the min priority queue, if x<y so x will be before y in the queue
 */
 class cellsCostCompearator implements Comparator<AState> {
    @Override
    public int compare(AState x, AState y) {
        if (x.getCost() < y.getCost()) {
            return -1;
        }
        if (x.getCost() > y.getCost()) {
            return 1;
        }
        return 0;// if the cost is equal
    }
}

