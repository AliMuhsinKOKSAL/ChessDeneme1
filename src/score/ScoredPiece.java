package score;

import java.util.ArrayList;
import java.util.Iterator;

import board.BoardCreator;
import option.OpType;
import option.Option;
import piece.Piece;

public class ScoredPiece {

	Piece piece;
	int point;
	ArrayList<ScoredSquare> scoredResults = new ArrayList<ScoredSquare>();

	public ScoredPiece(Piece piece) {
		this.piece = piece;
		point += BoardCreator.cBoard.scoreTool.pieceFactor(piece);
		scoreSquare();
	}

	public void scoreSquare() {
		for (Option opt : copyOptions()) {
			scoredResults.add(new ScoredSquare(this, opt.xsqu));
		}
	}

	public ArrayList<Option> copyOptions() {
		ArrayList<Option> copyOptionss = new ArrayList<Option>(BoardCreator.cBoard.boardTool.selectedPieceMove(piece));
		Iterator<Option> iterator = copyOptionss.iterator();
		while (iterator.hasNext()) {
			Option opt = iterator.next();
			if (opt.opType == OpType.notTake || opt.opType == OpType.notMovedTo) {
				iterator.remove();
			}
		}
		return copyOptionss;
	}	
}
