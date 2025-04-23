package score;

import board.BoardCreator;
import obj.PieceColor;
import piece.Piece;

public class ScoreWhite {
	
	public Piece bestWhitePiece;
	public ScoredSquare bestWhiteSquare;
	public int whitePiecesPoint = 0;
	public boolean isGameOver = false;
	
	public ScoreWhite() {
			ScoredSquare bestMove = BoardCreator.cBoard.scoreTool.findBestMove(BoardCreator.cBoard.scoreTool.computePieceScore(BoardCreator.cBoard.scoreTool.findPieces(PieceColor.white)));
			bestWhitePiece = bestMove.scoredPiece.piece;
			bestWhiteSquare = bestMove;
	}
}
