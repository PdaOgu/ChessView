package chessview.pieces;

import chessview.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Pawn.
 * implement pawn piece
 */
public class Pawn extends Piece {
    
    /** The can be en passant. */
    private boolean canBeEnPassant;
	
	/**
	 * Can be en passant.
	 *
	 * @return true, if successful
	 */
	public boolean canBeEnPassant () {
        return canBeEnPassant;
    }
	
	/**
	 * Sets the can be en passant.
	 *
	 * @param canBeEnPassant the new can be en passant
	 */
	public void setCanBeEnPassant (boolean canBeEnPassant) {
        this.canBeEnPassant = canBeEnPassant;
    }

    /**
     * Instantiates a new pawn.
     *
     * @param isWhite 
     */
    public Pawn (boolean isWhite) {
		super(isWhite);
		this.canBeEnPassant = false;		
	}
	
	/**
	 * Checks if is valid move.
	 *
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 * @param isTaken the is taken
	 * @param board the board
	 * @return true, if is valid move
	 */
	public boolean isValidMove (Position oldPosition, Position newPosition,
			Piece isTaken, Board board) {
	    
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
					        && p.getMoveCounter() == 0
					        && board.pieceAt(new Position(oldRow + dir, oldCol)) == null) {	       // move forward 2 squares
						isValid = true;
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
						if (((Pawn) isTaken).canBeEnPassant()
								&& ((this.isWhite() && oldRow == 5)
								|| (!this.isWhite() && oldRow == 4))) {
							isValid = true;
						}
					}
				}
			}
		}
		
		return isValid;
	}	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString () {
		if(this.isWhite()) {
			return "P";
		} else {
			return "p";
		}
	}
}
