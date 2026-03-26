package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj1436Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "2",
                        "1666",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "3",
                        "2666",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "6",
                        "5666",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "187",
                        "66666",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "500",
                        "166699",
                        2000,
                        128
                ))
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj1436::solve);
    }
}