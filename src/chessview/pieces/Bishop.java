package chessview.pieces;

import chessview.*;

public class Bishop extends PieceImpl implements Piece {
	public Bishop(boolean isWhite) {
		super(isWhite);
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
				
		/* Remark:
		 * clearDiaganolExcept() will return false if oldPostion and newPostion
		 * are not on a diagonal line, it means that the clearDiaganolExcept()
		 * will also check the validity of Bishop's path for us. 
		 */
		return board.clearDiaganolExcept(oldPosition, newPosition, p, t);
		
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
