package algorithms.Search;

import java.util.ArrayList;

public interface ISearchable {

    AState getStartState();
    AState getGoalState();

    public ArrayList<AState> getAllPossibleStates (AState state);
}
