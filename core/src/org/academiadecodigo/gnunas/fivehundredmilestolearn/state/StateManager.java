package org.academiadecodigo.gnunas.fivehundredmilestolearn.state;

public class StateManager {

    private AbstractState abstractState;

    public void setState(AbstractState abstractState) {
        this.abstractState = abstractState;
    }

    public AbstractState getState() {
        return abstractState;
    }
}
