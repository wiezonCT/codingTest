package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj1475Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "9999",
                        "2",
                        2000,
                        128
                )),
                Arguments.of(new TestCase(
                        "122",
                        "2",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "12635",
                        "1",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "888888",
                        "6",
                        2000,
                        128
                ))
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj1475::solve);
    }
}