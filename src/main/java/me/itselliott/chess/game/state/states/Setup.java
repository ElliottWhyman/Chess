package me.itselliott.chess.game.state.states;

import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.State;

public class Setup extends State {

    @Override
    public void initalise() {
        System.out.println("init");


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
