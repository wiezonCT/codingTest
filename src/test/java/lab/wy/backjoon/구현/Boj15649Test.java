package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj15649Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(
                        new TestCase(
                        "3 1",
                        "1\n" +
                                "2\n" +
                                "3",
                        2000,
                        128
                        )
                ),
                Arguments.of(
                        new TestCase(
                                "4 2",
                                "1 2\n" +
                                        "1 3\n" +
                                        "1 4\n" +
                                        "2 1\n" +
                                        "2 3\n" +
                                        "2 4\n" +
                                        "3 1\n" +
                                        "3 2\n" +
                                        "3 4\n" +
                                        "4 1\n" +
                                        "4 2\n" +
                                        "4 3",
                                2000,
                                128
                        )
                ),
                Arguments.of(
                        new TestCase(
                                "4 4",
                                "1 2 3 4\n" +
                                        "1 2 4 3\n" +
                                        "1 3 2 4\n" +
                                        "1 3 4 2\n" +
                                        "1 4 2 3\n" +
                                        "1 4 3 2\n" +
                                        "2 1 3 4\n" +
                                        "2 1 4 3\n" +
                                        "2 3 1 4\n" +
                                        "2 3 4 1\n" +
                                        "2 4 1 3\n" +
                                        "2 4 3 1\n" +
                                        "3 1 2 4\n" +
                                        "3 1 4 2\n" +
                                        "3 2 1 4\n" +
                                        "3 2 4 1\n" +
                                        "3 4 1 2\n" +
                                        "3 4 2 1\n" +
                                        "4 1 2 3\n" +
                                        "4 1 3 2\n" +
                                        "4 2 1 3\n" +
                                        "4 2 3 1\n" +
                                        "4 3 1 2\n" +
                                        "4 3 2 1",
                                2000,
                                128
                        )
                )
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj15649::solve);
    }
}