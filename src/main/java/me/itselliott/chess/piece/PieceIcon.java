package me.itselliott.chess.piece;

public enum PieceIcon {

    PAWN_WHITE("PawnWhite.png"),
    KNIGHT_WHITE("KnightWhite.png"),
    BISHOP_WHITE("BishopWhite.png"),
    ROOK_WHITE("RookWhite.png"),
    QUEEN_WHITE("QueenWhite.png"),
    KING_WHITE("KingWhite.png"),

    PAWN_BLACK("PawnBlack.png"),
    KNIGHT_BLACK("KnightBlack.png"),
    BISHOP_BLACK("BishopBlack.png"),
    ROOK_BLACK("RookBlack.png"),
    QUEEN_BLACK("QueenBlack.png"),
    KING_BLACK("KingBlack.png");

    private String location;

    PieceIcon(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

}
