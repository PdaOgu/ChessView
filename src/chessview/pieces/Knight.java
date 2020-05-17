package chessview.pieces;

import chessview.*;

public class Knight extends Piece {
	public Knight (boolean isWhite) {
		super(isWhite);
	}
		
	public boolean isValidMove (Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
	    
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		
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
		
		int diffCol = Math.abs(oldCol - newCol);
		int diffRow = Math.abs(oldRow - newRow);
		
		return ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
	}
	
	public String toString () {
		if(this.isWhite()) {
			return "N";
		} else {
			return "n";
		}
	}
}
