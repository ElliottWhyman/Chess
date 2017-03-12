package me.itselliott.chess.game.state;

import java.util.Collections;
import java.util.Set;

public class Transition {

    private final State from;
    private final State to;
    private final Set<Condition> conditions;


    public Transition(State from, State to, Set<Condition> conditions) {
        this.from = from;
        this.to = to;
        this.conditions = conditions;
    }

    public Transition(State from, State to, Condition condition) {
        this.from = from;
        this.to = to;
        this.conditions = Collections.singleton(condition);
    }

    public Set<Condition> getConditions() {
        return conditions;
    }

    public State getTo() {
        return to;
    }

    public State getFrom() {
        return from;
    }
}
