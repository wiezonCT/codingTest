package lab.wy.backjoon.구현;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import lab.wy.util.TestCase;
import lab.wy.util.TestRunner;

class Boj1316Test {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of(new TestCase(
                        "3\n" +
                                "happy\n" +
                                "new\n" +
                                "year",
                        "3",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "4\n" +
                                "aba\n" +
                                "abab\n" +
                                "abcabc\n" +
                                "a",
                        "1",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "5\n" +
                                "ab\n" +
                                "aa\n" +
                                "aca\n" +
                                "ba\n" +
                                "bb",
                        "4",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "2\n" +
                                "yzyzy\n" +
                                "zyzyz",
                        "0",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "1\n" +
                                "z",
                        "1",
                        2000,
                        128
                )),Arguments.of(new TestCase(
                        "9\n" +
                                "aaa\n" +
                                "aaazbz\n" +
                                "babb\n" +
                                "aazz\n" +
                                "azbz\n" +
                                "aabbaa\n" +
                                "abacc\n" +
                                "aba\n" +
                                "zzaz",
                        "2",
                        2000,
                        128
                ))
        );
    }

    @ParameterizedTest(name = "{index}번 테스트")
    @MethodSource("cases")
    void test(TestCase tc) throws Throwable {
        TestRunner.run(tc, Boj1316::solve);
    }
}