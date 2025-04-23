package oldscore;

import board.BoardCreator;
import obj.PieceColor;

public class ScoreMoveTool {
	
	ScoreWhite scrWhite;
	ScoreBlack scrBlack;
	
	public ScoreMoveTool() {
		scrWhite = new ScoreWhite();
		scrBlack = new ScoreBlack();
	}
	
	public void cMove() {
		if(BoardCreator.cBoard.boardTool.userColor.equals(PieceColor.white)) {
			ScoreSquare scrSquare = scrBlack.bestBlackMove();
			BoardCreator.cBoard.boardTool.move(scrSquare.scorePiece.piece, scrSquare.square.x, scrSquare.square.y);
		}else {
			ScoreSquare scrSquare = scrWhite.bestWhiteMove();
			BoardCreator.cBoard.boardTool.move(scrSquare.scorePiece.piece, scrSquare.square.x, scrSquare.square.y);
		}
	}
}
