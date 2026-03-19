package lab.wy.util;

public class TestCase {
    String input;
    String expected;
    long timeLimitMs;
    long memoryLimitMb;

    public TestCase(String input, String expected, long timeLimitMs, long memoryLimitMb) {
        this.input         = input;
        this.expected      = expected;
        this.timeLimitMs   = timeLimitMs;
        this.memoryLimitMb = memoryLimitMb;
    }
}
