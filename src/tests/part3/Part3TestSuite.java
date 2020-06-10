package tests.part3;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class Part3TestSuite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CastleTests.class,
        CheckTests.class,
        EnPassantTests.class,
        PromotionTests.class
})
public class Part3TestSuite {
}
