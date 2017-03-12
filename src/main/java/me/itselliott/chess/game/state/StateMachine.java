package me.itselliott.chess.game.state;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class StateMachine {

    private final List<Transition> transitions;
    private State currentState;

    public StateMachine(State start, List<Transition> transitions) {
        this.currentState = setCurrentState(start);
        this.transitions = transitions;
    }


    public State nextState(Condition condition) {
        return nextState(Collections.singleton(condition));
    }


    public State nextState(Set<Condition> conditions) {
        for (Transition transition : this.transitions) {
            if (transition.getConditions().equals(conditions) && transition.getFrom().equals(this.currentState)) {
                System.out.println("State: " + transition.getFrom().getClass().getSimpleName() + " -> " + transition.getTo().getClass().getSimpleName() );
                return setCurrentState(transition.getTo());
            }
        }
        return this.currentState;
    }


    private State setCurrentState(State state) {
        this.currentState = state;
        state.initalise();
        return state;
    }

    public State getCurrentState() {
        return currentState;
    }
}
