package algorithms.Search;

public interface ISearchingAlgorithm {

    public Solution solve(ISearchable domain);

    public String getName();

    public int getNumberOfNodesEvaluated();
}
