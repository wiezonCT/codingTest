package lab.jh.bakjoon.구현.나무꾼_이다솜_1421;

import lab.common.BojTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Test extends BojTestBase {

    @Override
    protected Class<?> getSolutionClass() {
        return Main.class;
    }

    @Override
    protected Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "3 1 10\n" +
                                "26\n" +
                                "103\n" +
                                "59",
                        "1770"
                ),
                Arguments.of(
                        "3 10 10\n" +
                                "26\n" +
                                "103\n" +
                                "59",
                        "1680"
                ),
                Arguments.of(
                        "3 100 10\n" +
                                "26\n" +
                                "103\n" +
                                "59",
                        "1230"
                ),
                Arguments.of(
                        "3 10 1\n" +
                                "5\n" +
                                "6\n" +
                                "5",
                        "10"
                ),
                Arguments.of(
                        "4 40 30\n" +
                                "1\n" +
                                "1\n" +
                                "1\n" +
                                "2",
                        "110"
                ),
                Arguments.of(
                        "4 40 30\n" +
                                "1\n" +
                                "1\n" +
                                "1\n" +
                                "3",
                        "100"
                )
        );
    }
}
