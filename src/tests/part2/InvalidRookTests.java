package tests.part2;

import org.junit.Test;
import junit.framework.TestCase;
import static tests.TestHelpers.*;

public class InvalidRookTests extends TestCase {
	

	// addition test cases
	public @Test void testInvalidRookMoves() {
		String[] tests = { 
			"Ra1-a6",
			"h2-h4 Rh8-h3",
			"b2-b3 b7-b6\nRa1-b2",
			"b2-b3 b7-b6\nb3-b4 Ra8-b7"
		};
		checkInvalidTests(tests);
	}
	
	public @Test void testInvalidRookTakes() {
		String[] tests = {
			
			// blocked
			"Ra1xa8",

			//diagonal
			"a2-a4 b7-b5\nRa1-a3 b5-b4\nRa3xb4",
			
			//L shape
			"a2-a4 c7-c5\nRa1-a3 c5-c4\nRa3xc4"
		};
		
		checkInvalidTests(tests);
	}
}
