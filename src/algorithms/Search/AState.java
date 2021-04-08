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

    /**
     * @return the cost of the movement between two state
     */
    public abstract int getCost();


    /**
     * @param state is the state that this state came from
     */
    public void setComeFrom(AState state)
    {
        if (state==null)
        {
            System.out.println("can't chage the father state because the state is null");
            System.exit(0);
        }
        this.comeFrom=state;
    }

    /**
     * @return the state that this state came from
     */
    public AState getComeFrom()
    {
        return comeFrom;
    }

    @Override
    public String toString() {
        return this.state;
    }
}
