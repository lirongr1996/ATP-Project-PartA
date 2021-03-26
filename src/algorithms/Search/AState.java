package algorithms.Search;

import java.util.Objects;

public abstract class AState {
    protected int cost;
    protected AState comeFrom;
    protected String state;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Objects.equals(state, aState.state);
    }

    public abstract int getCost();
}
