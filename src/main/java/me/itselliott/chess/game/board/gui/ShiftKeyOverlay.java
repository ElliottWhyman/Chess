package me.itselliott.chess.game.board.gui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import me.itselliott.chess.game.GameHandler;

public class ShiftKeyOverlay implements EventHandler<KeyEvent> {

    boolean pressedOrReleased;

    public ShiftKeyOverlay(boolean pressedOrReleased) {
        this.pressedOrReleased = pressedOrReleased;
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getCode() == KeyCode.SHIFT) {
            GameHandler.getStateMachine().getCurrentState().shiftOverlay(pressedOrReleased);
        }

    }
}
