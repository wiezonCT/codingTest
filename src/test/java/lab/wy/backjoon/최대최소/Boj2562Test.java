package lab.wy.backjoon.최대최소;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class Boj2562Test {
    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "3\n" +
                                "29\n" +
                                "38\n" +
                                "12\n" +
                                "57\n" +
                                "74\n" +
                                "40\n" +
                                "85\n" +
                                "61",
                        "85\n" +
                                "8",
                        1000, // ms
                        128   // MB
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj2562::solve);
    }


}
