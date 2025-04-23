package score;

import board.BoardCreator;
import obj.PieceColor;
import piece.Piece;

public class ScoreBlack {
	
	public Piece bestBlackPiece;
	public ScoredSquare bestBlackSquare;
	public int blackPiecesPoint = 0;
	public boolean isGameOver = false;
	
	public ScoreBlack() {
			ScoredSquare bestMove = BoardCreator.cBoard.scoreTool.findBestMove(BoardCreator.cBoard.scoreTool.computePieceScore(BoardCreator.cBoard.scoreTool.findPieces(PieceColor.black)));
			bestBlackPiece = bestMove.scoredPiece.piece;
			bestBlackSquare = bestMove;
	}	
}
