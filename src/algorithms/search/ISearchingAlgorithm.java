package algorithms.search;

public interface ISearchingAlgorithm {

    public Solution solve(ISearchable domain) throws Exception;

    public String getName();

    public int getNumberOfNodesEvaluated();
}
