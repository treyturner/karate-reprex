package info.treyturner.karate.reprex;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KarateRunner {

    @Test
    void testParallel() {
        int threads = Runtime.getRuntime().availableProcessors() / 2;
        Results results = Runner.path(".").tags("~@Ignore,~@Reusable").parallel(threads);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}
