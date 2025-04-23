package oldscore;

import java.util.ArrayList;

import board.BoardCreator;
import board.ChessBoard;
import obj.PieceColor;

public class ScoreBlack {
	ArrayList<ScorePiece> blackScorePieces;
	
	public ScoreBlack() {
		blackScorePieces = new  ArrayList<ScorePiece>();
		for(int i = 0;i<ChessBoard.BOARD_SIZE;i++) {
			for(int j = 0;j<ChessBoard.BOARD_SIZE;j++) {
				if(BoardCreator.cBoard.getSquare(i, j).piece != null) {
					if(BoardCreator.cBoard.getSquare(i, j).piece.color.equals(PieceColor.white)) {
						blackScorePieces.add(new ScorePiece(BoardCreator.cBoard.getSquare(i, j).piece));
					}
				}
			}
		}
	}
	
	ScoreSquare bestBlackMove() {
		ScoreSquare bestScoreSqr = blackScorePieces.get(0).scoreSquare.get(0);
		for(int i = 0;i<blackScorePieces.size();i++) {
			for(int j = 0;i<blackScorePieces.get(i).scoreSquare.size();j++) {
				if(bestScoreSqr.score < blackScorePieces.get(i).scoreSquare.get(j).score) {
					bestScoreSqr = blackScorePieces.get(i).scoreSquare.get(j);
				}else if(bestScoreSqr.score < blackScorePieces.get(i).scoreSquare.get(j).score) {
					bestScoreSqr = (Math.ceil(Math.random())==1)?bestScoreSqr:blackScorePieces.get(i).scoreSquare.get(j);
				}
			}
		}
		return bestScoreSqr;
	}
}