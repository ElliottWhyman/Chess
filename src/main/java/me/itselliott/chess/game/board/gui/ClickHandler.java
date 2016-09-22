package me.itselliott.chess.game.board.gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Promotable;

public class ClickHandler implements EventHandler<MouseEvent> {

    private Square square;
    private Rectangle rectangle;

    public ClickHandler(Square square) {
        this.square = square;
        this.rectangle = square.getRectangle();
    }

    public void handle(MouseEvent event) {
        if (event.getSource() == this.rectangle) {
            if (this.square.isOccupied()) {
                    System.out.println(square.toString());
                    this.movePieceIfValid();
                if (GameHandler.getCurrentTurn().equals(this.square.getPiece().getPlayer())) {
                    this.setSquareAndWaitForMove();
                }
            } else {
                System.out.println(square.toString());
                this.movePieceIfValid();
            }
        }
    }

    private void setSquareAndWaitForMove() {
        if (GameHandler.getGameState().equals(GameHandler.GameState.PLAYING)) {
            GameHandler.setActivePiece(this.square.getPiece());
            GameHandler.setGameState(GameHandler.GameState.WAITING);
        } else if (GameHandler.getGameState().equals(GameHandler.GameState.WAITING) && GameHandler.getActivePiece() != null && GameHandler.getActivePiece().equals(this.square.getPiece())) {
            GameHandler.setGameState(GameHandler.GameState.PLAYING);
            GameHandler.setActivePiece(null);
        } else if (GameHandler.getGameState().equals(GameHandler.GameState.WAITING) && GameHandler.getActivePiece() != null && GameHandler.getActivePiece().getPlayer().equals(GameHandler.getCurrentTurn())) {
            GameHandler.setActivePiece(square.getPiece());
        }
    }


    private void movePieceIfValid() {
        if (GameHandler.getGameState().equals(GameHandler.GameState.WAITING) && GameHandler.getActivePiece() != null && GameHandler.getActivePiece().canMove(square.getPositionVector())) {
            if (!promote()) {
                GameHandler.getActivePiece().move(this.square);
            }
            GameHandler.setActivePiece(null);
            GameHandler.setGameState(GameHandler.GameState.PLAYING);
            GameHandler.setCurrentTurn(Player.inverse());
        }
    }

    private boolean promote() {
        if (GameHandler.getGameState().equals(GameHandler.GameState.WAITING) && GameHandler.getActivePiece() != null && GameHandler.getActivePiece() instanceof Promotable ) {
            if ((GameHandler.getActivePiece().getPlayer().equals(Player.WHITE) && square.getPositionVector().getCartesianY() == 7)
                    || GameHandler.getActivePiece().getPlayer().equals(Player.BLACK) && square.getPositionVector().getCartesianY() == 0) {
                PromotableWindow window = new PromotableWindow(GameHandler.getActivePiece(), square);
                window.open();
                return true;
            }
        }
        return false;
    }
}
