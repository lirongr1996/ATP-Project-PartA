package algorithms.Search;

import java.util.Objects;

public abstract class AState {
    protected int cost;
    protected AState comeFrom;
    protected String state;
    private boolean visit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AState aState = (AState) o;
        return Objects.equals(state, aState.state);
    }

    public abstract int getCost();

    public boolean isVisit() {
        return visit;
    }

    public void setVisit(boolean visit) {
        this.visit = visit;
    }

    public boolean getVisit()
    {
        return this.visit;
    }
    public void setComeFrom(AState state)
    {
        this.comeFrom=state;
    }

    public AState getComeFrom()
    {
        return comeFrom;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
