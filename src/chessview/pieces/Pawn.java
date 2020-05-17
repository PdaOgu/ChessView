package chessview.pieces;

import chessview.*;

public class Pawn extends Piece {
	private boolean isFirstMove;
	public boolean isFirstMove () {
        return isFirstMove;
    }

    public void setFirstMove (boolean isFirstMove) {
        this.isFirstMove = isFirstMove;
    }

    private boolean canEnPassant;
	
	public boolean canEnPassant () {
        return canEnPassant;
    }

    public Pawn (boolean isWhite) {
		super(isWhite);
		this.isFirstMove = true;		
		this.canEnPassant = false;		
	}
	
	public boolean isValidMove (Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
	    
	    if (!this.isFirstMove) {
	        this.canEnPassant = false;
	    }
	    
		int dir = this.isWhite() ? 1 : -1;
		int oldRow = oldPosition.row();
		int oldCol = oldPosition.column();
		int newRow = newPosition.row();
		int newCol = newPosition.column();
		
		if (!Position.isValid(oldPosition)
                || !Position.isValid(newPosition))
            return false;

		Piece p = board.pieceAt(oldPosition);
		Piece t = board.pieceAt(newPosition);
				
		if (!this.equals(p))
			return false;
		
		
		boolean isValid = false;
		
		if (isTaken == null) {				// simple move, not take any piece
			if (oldCol == newCol) {
				if (t == null) {
					if (oldRow + dir == newRow) {	       // move forward 1 square
						isValid = true;
					} else if (oldRow + dir + dir == newRow
					        && this.isFirstMove) {	       // move forward 2 squares
						isValid = true;
						this.canEnPassant = true;
					}
				}
			}
		} else { 
			if (oldRow + dir == newRow && Math.abs(newCol - oldCol) == 1) {		// pawn take by move diagonally 1 square
				if (isTaken.equals(t) && this.isWhite() != t.isWhite()) {										// simple take of pawn
					isValid = true;
				} else {														// check valid en passant
					Piece adjacent = board.pieceAt(new Position(oldRow, newCol));	// for checking position of isTaken
					if ((isTaken instanceof Pawn)
							&& isTaken.equals(adjacent)
							&& this.isWhite() != isTaken.isWhite()) {
						if (((Pawn) isTaken).canEnPassant()
								&& (this.isWhite() && oldRow == 5)
								&& (!this.isWhite() && oldRow == 4)) {
							isValid = true;
						}
					}
				}
			}
		}
		
		return isValid;
	}	
	
	public String toString () {
		if(this.isWhite()) {
			return "P";
		} else {
			return "p";
		}
	}
}
