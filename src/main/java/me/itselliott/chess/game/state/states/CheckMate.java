package me.itselliott.chess.game.state.states;

import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.State;

public class CheckMate extends State {

    @Override
    public void initalise() {
        System.out.println("Game Over, " + Player.inverse(GameHandler.getCurrentTurn()).toString() + " has won!");
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
