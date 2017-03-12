package me.itselliott.chess.game;

import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.Condition;
import me.itselliott.chess.game.state.StateMachine;
import me.itselliott.chess.game.state.Transition;
import me.itselliott.chess.game.state.states.*;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.pieces.King;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameHandler {

    public static final StateMachine stateMachine;
    private static final GameData gameData = GameData.getGameData();

    private GameHandler() {}

    static {
        System.out.println("1");
        stateMachine = makeStateMachine();
    }

    public static void start() {
        System.out.println("2");
        stateMachine.nextState(Condition.TURN_START);
    }


    public static Player getCurrentTurn() {
        return gameData.currentTurn;
    }

    public static void changeCurrentTurn() {
       gameData.currentTurn = Player.inverse(gameData.currentTurn);
    }

    public static Piece getCurrentPiece() {
        return gameData.currentPiece;
    }

    public static void setCurrentPiece(Piece piece) {
        gameData.currentPiece = piece;
    }

    public static StateMachine getStateMachine() {
        return stateMachine;
    }

    public static void queryCheck(Player player) {
        Set<Square> allMoves = new HashSet<>();
        for (Piece piece : PieceHandler.getActivePieces(Player.inverse(player))) {
            allMoves.addAll(piece.getMoves());
        }
        if (allMoves.contains(Board.getSquare(PieceHandler.getPieceByPlayer(King.class, player).getPositionVector()))) {
            stateMachine.nextState(Condition.CHECK);
        }
        if (allMoves.containsAll(PieceHandler.getPieceByPlayer(King.class, player).getMoves())) {
            stateMachine.nextState(Condition.CHECK_MATE);
        }


    }

    private static StateMachine makeStateMachine() {
        System.out.println("hi");
        TurnStart turnStart = new TurnStart();
        Playing playing = new Playing();
        TurnEnd turnEnd = new TurnEnd();
        Check check = new Check();
        CheckMate checkMate = new CheckMate();
        Forfeit forfeit = new Forfeit();
        Setup setup = new Setup();

        List<Transition> transitions = new ArrayList<>();
        transitions.add(new Transition(setup, turnStart, Condition.TURN_START));
        transitions.add(new Transition(turnStart, playing, Condition.PIECE_SELECTION));
        transitions.add(new Transition(playing, turnStart, Condition.DROP_SELECTION));
        transitions.add(new Transition(playing, turnEnd, Condition.TURN_END));
        transitions.add(new Transition(turnEnd, turnStart, Condition.TURN_START));
        transitions.add(new Transition(turnStart, check, Condition.CHECK));
        transitions.add(new Transition(check, turnEnd, Condition.TURN_END));
        transitions.add(new Transition(check, checkMate, Condition.CHECK_MATE));
        transitions.add(new Transition(playing, forfeit, Condition.FORFEIT));
        transitions.add(new Transition(turnEnd, forfeit, Condition.FORFEIT));
        transitions.add(new Transition(check, forfeit, Condition.FORFEIT));
        System.out.println("11");
        return new StateMachine(setup, transitions);
    }

}


