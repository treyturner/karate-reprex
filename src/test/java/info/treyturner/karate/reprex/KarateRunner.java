package info.treyturner.karate.reprex;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class KarateRunner {

    // Parallel JUnit 5
    @Test
    void testParallel() {
        int threads = Runtime.getRuntime().availableProcessors() / 2;
        Results results = Runner.path("classpath:").reportDir("build/reports/surefire").tags("~@Ignore", "~@Reusable").parallel(threads);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    // Serial JUnit 5
//    @Karate.Test
//    Karate testFullPath() {
//        return Karate.run("classpath:").tags("~@Reusable,~@Ignore");
//    }
}
