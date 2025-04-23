package oldscore;

import java.util.ArrayList;

import board.BoardCreator;
import option.Option;
import piece.Piece;

public class ScorePiece {

	Piece piece;
	ArrayList<ScoreSquare> scoreSquare;
	
	public ScorePiece(Piece piece) {
		this.piece = piece;
		scoreSquare = new ArrayList<ScoreSquare>();
		for(Option opt: BoardCreator.cBoard.boardTool.selectedPieceMove(piece)) {
			scoreSquare.add(new ScoreSquare(this, opt.xsqu));
		}
	}
	
	void calc() {
		
	}
	
}
