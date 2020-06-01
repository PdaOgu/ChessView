package chessview.pieces;

import chessview.*;

/**
 * The Class King.
 * implement king piece
 */
public class King extends Piece {
	
	/**
	 * Instantiates a new king.
	 *
	 * @param isWhite the is white
	 */
	public King (boolean isWhite) {
		super(isWhite);
	}	
	
	/**
	 * Checks if is valid move.
	 *
	 * @param oldPosition the old position
	 * @param newPosition the new position
	 * @param isTaken the is taken
	 * @param board the board
	 * @return true, if it is valid move
	 */
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

		boolean isValid = false;
		int diffCol = Math.abs(oldCol - newCol);
		int diffRow = Math.abs(oldRow - newRow);
		if ((diffCol == 1 || diffRow == 1) && diffCol <= 1 && diffRow <= 1) {		// regular case
			isValid = true;
		} else {
			// check valid castling move
			if (oldRow == newRow
					&& ((oldRow == 1 && this.isWhite()) || (oldRow == 8 && !this.isWhite()))) {
				if (newCol == 3 || newCol == 7) {
					Position rookPos = new Position(oldRow, newCol == 3 ? 1 : 8);
					Piece rook = board.pieceAt(rookPos);
					
					if (p.getMoveCounter() == 0 && rook.getMoveCounter() == 0
							&& board.clearRowExcept(oldPosition, rookPos, p, rook)) {
						int increment = newCol == 3 ? -1 : +1;
						Board tmpBoard = new Board(board);
						Piece tmpPiece = tmpBoard.pieceAt(oldPosition);
						for (int i = oldCol; i != newCol + increment; i += increment) {
							Position tryPos = new Position(oldRow, i);
							tmpBoard.setPieceAt(oldPosition, null);
							tmpBoard.setPieceAt(tryPos, tmpPiece);
							if (tmpBoard.isInCheck(this.isWhite())) {
								return false;
							}
							tmpBoard.setPieceAt(oldPosition, tmpPiece);
							tmpBoard.setPieceAt(tryPos, null);
						}
						isValid = true;
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
			return "K";
		} else {
			return "k";
		}
	}
}
