package score;

import java.util.ArrayList;

import board.BoardCreator;
import board.ChessBoard;
import obj.Square;
import option.Option;
import piece.Piece;

public class ScoredSquare {

	ScoredPiece scoredPiece;
	public int result;
	public Square square;

	int pieceFactor;

	public ScoredSquare(ScoredPiece scoredPiece, Square square) {
		this.scoredPiece = scoredPiece;
		this.square = square;
		this.result = sqrCloseCenter() + squareInThread() + squareEatPiece() + (scoredPiece.point / 2);
		pieceFactor = BoardCreator.cBoard.scoreTool.pieceFactor(scoredPiece.piece);
	}

	int sqrCloseCenter() {
		int dx = (Math.abs(4 - square.x) > Math.abs(3 - square.x)) ? Math.abs(3 - square.x) : Math.abs(4 - square.x);
		int dy = (Math.abs(4 - square.y) > Math.abs(3 - square.y)) ? Math.abs(3 - square.y) : Math.abs(4 - square.y);

		int dxy = -(dx + dy) * 5;
		return (dxy == 0) ? 5 : dxy;
	}

	int squareInThread() {
		ArrayList<Piece> attackers = listOfSqrAttackers();
		ArrayList<Piece> protecters = listOfSqrProtecters();
		int score = 0;
		boolean isFirst = true;

		if (!attackers.isEmpty()) {
			for (Piece attacker : attackers) {
				int attackerFactor = BoardCreator.cBoard.scoreTool.pieceFactor(attacker);
				if (attackerFactor >= pieceFactor) {
					if (!protecters.isEmpty()) {
						//square e tehdit var ama korunuyor
						score += 3050;
					} else {
						if (!isFirst) {
							//square e tehdit var korunmuyor
							score -= 8575;
						}
						isFirst = false;
					}
				} else {
					//square tehdit altında ve factörü rakipten fazla
					score -= 7750;
				}
			}
		}else {
			//square tehdit altında değil
			score+=4500;
		}
		return score;
	}

	int squareEatPiece() {
		int score = 0;
		if (square.piece != null) {
			Piece opponentPiece = square.piece;
			if(opponentPiece.color != scoredPiece.piece.color) {
				ArrayList<Piece> prList = listOfSqrProtecters();
				System.out.println("protected size: "+prList.size());
				if(!prList.isEmpty()) {
					if(BoardCreator.cBoard.scoreTool.pieceFactor(opponentPiece) > pieceFactor) {
						//square de rakip taş var korunuyor ve pFactör oppentınkinden daha küçük
						score += 2500;
					}else if(BoardCreator.cBoard.scoreTool.pieceFactor(opponentPiece) == pieceFactor) {
						//square de rakip taş var korunuyor ve pFactör oppentınkine eşit
						score += 1750;
					}else {
						//square de rakip taş var korunuyor ve pFactör oppentınkinden daha büyük
						score -= 5245;
					}
				}else {
					//square de rakip taş var ve korunmuyor
					score += 4750;
				}
			}
		}
		return score;
	}

	ArrayList<Piece> listOfSqrAttackers() {
		ArrayList<Piece> attackers = new ArrayList<Piece>();

		for (int i = 0; i < ChessBoard.BOARD_SIZE; i++) {
			for (int j = 0; j < ChessBoard.BOARD_SIZE; j++) {
				Piece attPiece = BoardCreator.cBoard.getSquare(i, j).piece;
				if (attPiece != null) {
					if (!attPiece.color.equals(scoredPiece.piece.color)) {
						for (Option opt : BoardCreator.cBoard.boardTool.selectedPieceMove(attPiece)) {
							if (opt.xsqu.equals(square)) {
								attackers.add(attPiece);
							}
						}
					}
				}
			}
		}
		return attackers;
	}

	ArrayList<Piece> listOfSqrProtecters() {
		ArrayList<Piece> protecters = new ArrayList<Piece>();

		for (int i = 0; i < ChessBoard.BOARD_SIZE; i++) {
			for (int j = 0; j < ChessBoard.BOARD_SIZE; j++) {
				Piece prPiece = BoardCreator.cBoard.getSquare(i, j).piece;
				if (prPiece != null) {
					if (prPiece.color.equals(scoredPiece.piece.color)) {
						for (Option opt : BoardCreator.cBoard.boardTool.selectedPieceMove(prPiece)) {
							if (opt.xsqu.equals(square)) {
								protecters.add(prPiece);
							}
						}
					}
				}
			}
		}
		return protecters;
	}
}
