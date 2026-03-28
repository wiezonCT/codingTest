package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj1018Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "8 8\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBBBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW",
                        "1",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "10 13\n" +
                                "BBBBBBBBWBWBW\n" +
                                "BBBBBBBBBWBWB\n" +
                                "BBBBBBBBWBWBW\n" +
                                "BBBBBBBBBWBWB\n" +
                                "BBBBBBBBWBWBW\n" +
                                "BBBBBBBBBWBWB\n" +
                                "BBBBBBBBWBWBW\n" +
                                "BBBBBBBBBWBWB\n" +
                                "WWWWWWWWWWBWB\n" +
                                "WWWWWWWWWWBWB",
                        "12",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "8 8\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB",
                        "0",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "9 23\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBB\n" +
                                "BBBBBBBBBBBBBBBBBBBBBBW",
                        "31",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "10 10\n" +
                                "BBBBBBBBBB\n" +
                                "BBWBWBWBWB\n" +
                                "BWBWBWBWBB\n" +
                                "BBWBWBWBWB\n" +
                                "BWBWBWBWBB\n" +
                                "BBWBWBWBWB\n" +
                                "BWBWBWBWBB\n" +
                                "BBWBWBWBWB\n" +
                                "BWBWBWBWBB\n" +
                                "BBBBBBBBBB",
                        "0",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "8 8\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBBBWBW\n" +
                                "WBWBWBWB\n" +
                                "BWBWBWBW\n" +
                                "WBWBWWWB\n" +
                                "BWBWBWBW\n",
                        "2",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "11 12\n" +
                                "BWWBWWBWWBWW\n" +
                                "BWWBWBBWWBWW\n" +
                                "WBWWBWBBWWBW\n" +
                                "BWWBWBBWWBWW\n" +
                                "WBWWBWBBWWBW\n" +
                                "BWWBWBBWWBWW\n" +
                                "WBWWBWBBWWBW\n" +
                                "BWWBWBWWWBWW\n" +
                                "WBWWBWBBWWBW\n" +
                                "BWWBWBBWWBWW\n" +
                                "WBWWBWBBWWBW",
                        "15",
                        2000,
                        128
                ))
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj1018::solve);
        TestRunner.run(tc, Boj1018Optimizer::solve);
    }
}