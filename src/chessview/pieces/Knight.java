package chessview.pieces;

import chessview.*;

public class Knight extends PieceImpl implements Piece {
	public Knight(boolean isWhite) {
		super(isWhite);
	}
		
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		
		if ((oldRow < 1 && oldRow > 8) || (oldCol < 1 && oldCol > 8)
				|| (newRow < 1 && newRow > 8) || (newCol < 1 && newCol > 8))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p) || (isTaken != null && !isTaken.equals(t)))
			return false;
		
		int diffCol = Math.abs(oldCol - newCol);
		int diffRow = Math.abs(oldRow - newRow);
		
		return ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
//		return this.equals(p)
//				&& (t == isTaken || isTaken != null)
//				&& ((diffCol == 2 && diffRow == 1) || (diffCol == 1 && diffRow == 2));
	}
	
	public String toString() {
		if(isWhite) {
			return "N";
		} else {
			return "n";
		}
	}
}
