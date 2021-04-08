package algorithms.Search;

import java.util.ArrayList;

public interface ISearchable {

    AState getStartState();
    AState getGoalState();

    public ArrayList<AState> getAllSuccessors (AState state) throws Exception;

    public void clearVisit();
}
