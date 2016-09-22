package me.itselliott.chess.game.board.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.Claimable;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.Promotable;


public class PromotableWindow  {

    private Piece piece;
    private Square to;
    private Stage stage;

    public PromotableWindow(Piece piece, Square to) {
        this.piece = piece;
        this.to = to;
        this.stage = new Stage();
        this.stage.setTitle("Promote your piece!");
        this.stage.setScene(new Scene(makeButtons()));
    }

    public void open() {
        this.stage.show();
    }


    private VBox makeButtons() {
        VBox vBox = new VBox();
        for (Piece buttonPiece : PieceHandler.getTakenPieces(this.piece.getPlayer())) {
            if (buttonPiece instanceof Claimable) {
                Button button = new Button(buttonPiece.getClass().getSimpleName());
                button.setOnAction(event -> {
                    if (piece instanceof Promotable) {
                        Promotable promotable = (Promotable) piece;
                        promotable.promote(piece, buttonPiece, to);
                        stage.close();
                    }
                });
                vBox.getChildren().add(button);
            }
        }
        return vBox;
    }
}
