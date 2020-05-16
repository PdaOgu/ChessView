package chessview.pieces;

import chessview.*;

public class Bishop extends PieceImpl implements Piece {
	public Bishop(boolean isWhite) {
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
				
		/* Remark:
		 * clearDiaganolExcept() will return false if oldPostion and newPostion
		 * are not on a diagonal line, it means that the clearDiaganolExcept()
		 * will also check the validity of Bishop's path for us. 
		 */
		if (board.clearDiaganolExcept(oldPosition, newPosition, p, t)) {
			return true;
		}
		
		return false;
		
//		return this.equals(p)
//				&& (t == isTaken || (isTaken != null && isTaken.equals(t)))
//				&& (board.clearDiaganolExcept(oldPosition, newPosition, p, t)
//						|| board.clearColumnExcept(oldPosition, newPosition, p,
//								t) || board.clearRowExcept(oldPosition,
//						newPosition, p, t));				
	}
	
	public String toString() {
		if(isWhite) {
			return "B";
		} else {
			return "b";
		}
	}
}
