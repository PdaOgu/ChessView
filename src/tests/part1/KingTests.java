package tests.part1;

import org.junit.Test;
import junit.framework.TestCase;
import static tests.TestHelpers.*;

/**
 * The Class KingTests.
 */
public class KingTests extends TestCase {
	
	/**
	 * Test king moves.
	 */
	public @Test void testKingMoves() {
		String[][] tests = { 
				// Test 1
				{"e2-e4 d7-d5\nKe1-e2",
				 "8|r|n|b|q|k|b|n|r|\n"+
				 "7|p|p|p|_|p|p|p|p|\n"+
				 "6|_|_|_|_|_|_|_|_|\n"+
				 "5|_|_|_|p|_|_|_|_|\n"+
				 "4|_|_|_|_|P|_|_|_|\n"+
				 "3|_|_|_|_|_|_|_|_|\n"+
				 "2|P|P|P|P|K|P|P|P|\n"+
				 "1|R|N|B|Q|_|B|N|R|\n"+
				 "  a b c d e f g h"
				},
				// Test 2
				{"e2-e4 d7-d5\nBf1-d3 d5xe4\nKe1-f1",
				 "8|r|n|b|q|k|b|n|r|\n"+
				 "7|p|p|p|_|p|p|p|p|\n"+
				 "6|_|_|_|_|_|_|_|_|\n"+
				 "5|_|_|_|_|_|_|_|_|\n"+
				 "4|_|_|_|_|p|_|_|_|\n"+
				 "3|_|_|_|B|_|_|_|_|\n"+
				 "2|P|P|P|P|_|P|P|P|\n"+
				 "1|R|N|B|Q|_|K|N|R|\n"+
				 "  a b c d e f g h"
				},
				// Test 3
				{"e2-e4 d7-d5\nBf1-d3 Ke8-d7",
				 "8|r|n|b|q|_|b|n|r|\n"+
				 "7|p|p|p|k|p|p|p|p|\n"+
				 "6|_|_|_|_|_|_|_|_|\n"+
				 "5|_|_|_|p|_|_|_|_|\n"+
				 "4|_|_|_|_|P|_|_|_|\n"+
				 "3|_|_|_|B|_|_|_|_|\n"+
				 "2|P|P|P|P|_|P|P|P|\n"+
				 "1|R|N|B|Q|K|_|N|R|\n"+
				 "  a b c d e f g h"
				},
				// Test 4
				{"e2-e4 d7-d5\nBf1-d3 Qd8-d6\ne4xd5 Ke8-d8",
				 "8|r|n|b|k|_|b|n|r|\n"+
				 "7|p|p|p|_|p|p|p|p|\n"+
				 "6|_|_|_|q|_|_|_|_|\n"+
				 "5|_|_|_|P|_|_|_|_|\n"+
				 "4|_|_|_|_|_|_|_|_|\n"+
				 "3|_|_|_|B|_|_|_|_|\n"+
				 "2|P|P|P|P|_|P|P|P|\n"+
				 "1|R|N|B|Q|K|_|N|R|\n"+
				 "  a b c d e f g h"
				}			
		};
		checkValidTests(tests);
	}
	// additional test cases
	public @Test void testKingTakes() {
		String[][] tests = {
			{"e2-e3 e7-e5\nKe1-e2 d7-d5\ne3-e4 d5-d4\nKe2-d3 c7-c5\nKd3-c4 d4-d3\nf2-f3 Qd8-g5\nKc4xd3",
				"8|r|n|b|_|k|b|n|r|\n"+
				"7|p|p|_|_|_|p|p|p|\n"+
				"6|_|_|_|_|_|_|_|_|\n"+
				"5|_|_|p|_|p|_|q|_|\n"+
				"4|_|_|_|_|P|_|_|_|\n"+
				"3|_|_|_|K|_|P|_|_|\n"+
				"2|P|P|P|P|_|_|P|P|\n"+
				"1|R|N|B|Q|_|B|N|R|\n"+
				"  a b c d e f g h"
	 		}
		};
		checkValidTests(tests);
	}
}
