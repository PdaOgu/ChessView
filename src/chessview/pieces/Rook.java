package chessview.pieces;

import chessview.*;

public class Rook extends PieceImpl implements Piece {
	boolean isFirstMove;
	public Rook(boolean isWhite) {
		super(isWhite);
		this.isFirstMove = true;
	}
	
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		
		if (!Position.isValid(oldPosition)
				|| !Position.isValid(newPosition))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p) || (isTaken != null && !isTaken.equals(t)))
			return false;
		
		boolean isValid = board.clearColumnExcept(oldPosition, newPosition, p, t)
						|| board.clearRowExcept(oldPosition, newPosition, p, t);
		if (isValid)
			this.isFirstMove = false;
		
		return isValid; 
	}
	
	public String toString() {
		if(isWhite) {
			return "R";
		} else {
			return "r";
		}
	}
}
