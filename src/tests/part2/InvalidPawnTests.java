package tests.part2;

import org.junit.Test;
import junit.framework.TestCase;
import static tests.TestHelpers.*;

/**
 * The Class InvalidPawnTests.
 */
public class InvalidPawnTests extends TestCase {
	
	/**
	 * Test invalid pawn moves.
	 */
	public @Test void testInvalidPawnMoves() {
		String[] tests = { 
			"e2-e3 c7-c6\ne3-e5",
			"e2-e5",
			"e2-e4 e7-e5\ne4-d5",
			"e2-e4 e7-e5\ne4-e3",
			"a2-a3 d7-d5\na3-a4 d5-d4\na4-a5 d4-d3\nd2-d4",
			"a2-a3 d7-d5\na3-a4 d5-d4\nd2-d4",

			//additional test cases
			"e2-d3",
			"e2-e3 e7-d6",
			"e2-e4 e7-e6\ne4-d4",
			"e2-e4 e7-e6\nd2-d4 e6-d6",
		};
		checkInvalidTests(tests);
	}
	
	/**
	 * Test invalid pawn takes.
	 */
	public @Test void testInvalidPawnTakes() {
		String[] tests = {
			"e2-e4 e7-e5\ne4xe5",
			"c2-c4 e7-e6\nc4xe6",
			"c2-c4 d7-d6\nc4xd6",
			"c2-c4 d7-d6\nc4xd5",
			"c2-c4 d7-d5\nc4-c5 d5-d4\nc5xd4"
		};
		
		checkInvalidTests(tests);
	}
}
