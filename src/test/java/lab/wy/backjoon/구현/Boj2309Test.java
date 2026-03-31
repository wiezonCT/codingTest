package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj2309Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "20\n" +
                                "7\n" +
                                "23\n" +
                                "19\n" +
                                "10\n" +
                                "15\n" +
                                "25\n" +
                                "8\n" +
                                "13",
                        "7\n" +
                                "8\n" +
                                "10\n" +
                                "13\n" +
                                "19\n" +
                                "20\n" +
                                "23",
                        2000,
                        128
                ))
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj2309::solve);
    }
}