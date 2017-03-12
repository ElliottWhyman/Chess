package me.itselliott.chess.game.state;

import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.board.Square;

public abstract class State {

    public State() {
    }



    public abstract void initalise();
    public abstract void move(Square to);
    public abstract void onMouseClick(MouseEvent event, Square square);
    public abstract void shiftOverlay(boolean toggle);


}
