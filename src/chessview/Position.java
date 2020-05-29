package chessview;

/**
 * the class is used to locate the pieces on the chess board.
 *
 * @author hung
 */
public final class Position {
	
	/** The row. */
	private int row; // must be between 1 and 8
	
	/** The col. */
	private int col; // must be between 1 and 8
	
	/**
	 * Instantiates a new position.
	 *
	 * @param row 
	 * @param col 
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Row.
	 *
	 * @return the int
	 */
	public int row() { 
		return row; 
	}
	
	/**
	 * Column.
	 *
	 * @return the int
	 */
	public int column() { 
		return col; 
	}
	
	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	public boolean equals(Object o) {
		if(o instanceof Position) {
			Position p = (Position) o;
			return row == p.row && col == p.col;
		}
		return false;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	public int hashCode() {
		return row ^ col;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {		
		return ((char)('a'+(col-1))) + Integer.toString(row);		
	}
	
	/**
	 * Checks if is valid.
	 *
	 * @param p 
	 * @return true, if is valid
	 */
	public static boolean isValid (Position p) {
		return (1 <= p.row() && p.row() <= 8) && (1 <= p.column() && p.column() <= 8);
	}
}
