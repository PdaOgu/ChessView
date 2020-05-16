package chessview.pieces;

import chessview.*;

public class Pawn extends PieceImpl implements Piece {
	boolean isFirstMove;
	boolean canEnPassant;
	public Pawn(boolean isWhite) {
		super(isWhite);
		this.isFirstMove = true;		//
		this.canEnPassant = false;		// By default, 
	}
	
	public boolean isValidMove(Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
		int dir = this.isWhite ? 1 : -1;
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		
		if ((oldRow < 1 && oldRow > 8) || (oldCol < 1 && oldCol > 8)
				|| (newRow < 1 && newRow > 8) || (newCol < 1 && newCol > 8))
			return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p))
			return false;
		
		
		boolean isValid = false;
		
		if (isTaken == null) {				// simple move, not take any piece
			if (oldCol == newCol) {		
				if (oldRow + dir == newRow) {	// move forward 1 square
					isValid = true;
					this.canEnPassant = false;
				} else if (oldRow + dir + dir == newRow && this.isFirstMove) {	// move forward 2 squares
					isValid = true;
					this.canEnPassant = true;
				}
			}
		} else { 
			if (oldRow + dir == newRow && Math.abs(newCol - oldCol) == 1) {		// pawn take by move diagonally 1 square
				if (isTaken.equals(t)) {										// simple take of pawn
					isValid = true;
				} else {														// can be special case en passant
					Piece adjacent = board.pieceAt(new Position(oldRow, newCol));	// for checking position of isTaken
					if ((isTaken instanceof Pawn) && isTaken.equals(adjacent)) {
						if (((Pawn) isTaken).canEnPassant
								&& (this.isWhite && oldRow == 5)
								&& (!this.isWhite && oldRow == 4)) {
							isValid = true;
						}
					}
				}
			}
		}
		
		if (isValid) {
			this.isFirstMove = false;
		}
		
//		if ((oldRow + dir) == newRow && oldCol == newCol) {						// move 1 square
//			return this.equals(p) && t == null;
//		} else if ((oldRow + dir + dir) == newRow && oldCol == newCol) {		// move 2 square	
//			return ((dir == 1 && oldRow == 2) || (dir == -1 && oldRow == 7))	
//					&& t == null && this.equals(p);
//		}
		return isValid;
	}	
	
	public String toString() {
		if(isWhite) {
			return "P";
		} else {
			return "p";
		}
	}
}
