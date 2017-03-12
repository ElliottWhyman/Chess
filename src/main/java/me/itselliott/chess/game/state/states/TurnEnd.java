package me.itselliott.chess.game.state.states;

import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.Condition;
import me.itselliott.chess.game.state.State;

public class TurnEnd extends State {

    @Override
    public void initalise() {
        GameHandler.changeCurrentTurn();
        GameHandler.getStateMachine().nextState(Condition.TURN_START);
    }

    @Override
    public void move(Square to) {

    }

    @Override
    public void onMouseClick(MouseEvent event, Square square) {

    }

    @Override
    public void shiftOverlay(boolean toggle) {

    }
}
