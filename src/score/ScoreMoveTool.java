package score;

import board.BoardCreator;
import obj.PieceColor;

public class ScoreMoveTool {

	public void cMove() {
		if(BoardCreator.cBoard.boardTool.userColor != BoardCreator.cBoard.boardTool.queue) {
			if (BoardCreator.cBoard.boardTool.userColor != PieceColor.white) {
				ScoreWhite swPiece = new ScoreWhite();
				if (!swPiece.isGameOver) {
					BoardCreator.cBoard.boardTool.move(swPiece.bestWhitePiece, swPiece.bestWhiteSquare.square.x,
							swPiece.bestWhiteSquare.square.y);
					System.out.println(swPiece.bestWhiteSquare.result);
				}
			} else {
				ScoreBlack sbPiece = new ScoreBlack();
				if (!sbPiece.isGameOver) {
					BoardCreator.cBoard.boardTool.move(sbPiece.bestBlackPiece, sbPiece.bestBlackSquare.square.x,
							sbPiece.bestBlackSquare.square.y);
					System.out.println(sbPiece.bestBlackSquare.result);
				}
			}
		}
	}
}
