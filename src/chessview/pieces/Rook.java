package chessview.pieces;

import chessview.*;

public class Rook extends Piece {

    public Rook (boolean isWhite) {
		super(isWhite);
	}
	
	public boolean isValidMove (Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		
		if (!Position.isValid(oldPosition)
				|| !Position.isValid(newPosition))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p)
                || (t == null && isTaken != null)            
                || (t != null && isTaken == null)              
                || (t != null && !t.equals(isTaken))            
                || (t != null && t.isWhite() == this.isWhite()))
            return false;
		
		boolean isValid = board.clearColumnExcept(oldPosition, newPosition, p, t)
						|| board.clearRowExcept(oldPosition, newPosition, p, t);
		
		return isValid; 
	}
	
	public String toString () {
		if(this.isWhite()) {
			return "R";
		} else {
			return "r";
		}
	}
}
