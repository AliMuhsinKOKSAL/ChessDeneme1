package oldscore;

import java.util.ArrayList;

import board.BoardCreator;
import board.ChessBoard;
import obj.Square;
import option.Option;
import piece.Piece;

public class ScoreSquare {

	ScorePiece scorePiece;
	Square square;
	public int score;

	public ScoreSquare(ScorePiece scorePiece, Square square) {
		this.scorePiece = scorePiece;
		this.square = square;
	}

	ArrayList<Piece> sqrAttacker() {
		ArrayList<Piece> attacker = new ArrayList<Piece>();
		for (int i = 0; i < ChessBoard.BOARD_SIZE; i++) {
			for (int j = 0; j < ChessBoard.BOARD_SIZE; j++) {
				if (BoardCreator.cBoard.getSquare(i, j).piece != null) {
					if (scorePiece.piece.color != BoardCreator.cBoard.getSquare(i, j).piece.color) {
						for (Option opt : BoardCreator.cBoard.boardTool
								.selectedPieceMove(BoardCreator.cBoard.getSquare(i, j).piece)) {
							if (opt.xsqu.equals(scorePiece.piece.square)) {
								attacker.add(BoardCreator.cBoard.getSquare(i, j).piece);
							}
						}
					}
				}
			}
		}
		return attacker;
	}

}
