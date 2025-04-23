package oldscore;

import java.util.ArrayList;

import board.BoardCreator;
import board.ChessBoard;
import obj.PieceColor;

public class ScoreWhite {
	ArrayList<ScorePiece> whiteScorePieces;
	
	public ScoreWhite() {
		whiteScorePieces = new  ArrayList<ScorePiece>();
		for(int i = 0;i<ChessBoard.BOARD_SIZE;i++) {
			for(int j = 0;j<ChessBoard.BOARD_SIZE;j++) {
				if(BoardCreator.cBoard.getSquare(i, j).piece != null) {
					if(BoardCreator.cBoard.getSquare(i, j).piece.color.equals(PieceColor.white)) {
						whiteScorePieces.add(new ScorePiece(BoardCreator.cBoard.getSquare(i, j).piece));
					}
				}
			}
		}
	}
	
	ScoreSquare bestWhiteMove() {
		ScoreSquare bestScoreSqr = whiteScorePieces.get(0).scoreSquare.get(0);
		for(int i = 0;i<whiteScorePieces.size();i++) {
			for(int j = 0;i<whiteScorePieces.get(i).scoreSquare.size();j++) {
				if(bestScoreSqr.score < whiteScorePieces.get(i).scoreSquare.get(j).score) {
					bestScoreSqr = whiteScorePieces.get(i).scoreSquare.get(j);
				}else if(bestScoreSqr.score < whiteScorePieces.get(i).scoreSquare.get(j).score) {
					bestScoreSqr = (Math.ceil(Math.random())==1)?bestScoreSqr:whiteScorePieces.get(i).scoreSquare.get(j);
				}
			}
		}
		return bestScoreSqr;
	}
	
}