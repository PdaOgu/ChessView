package tests.part2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class Part2TestSuite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        InvalidPawnTests.class,
        InvalidKnightTests.class,
        InvalidBishopTests.class,
        InvalidRookTests.class,
        InvalidQueenTests.class,
        InvalidKingTests.class
})
public class Part2TestSuite {
}
