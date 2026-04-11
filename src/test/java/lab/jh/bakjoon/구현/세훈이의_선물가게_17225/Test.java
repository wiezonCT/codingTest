package lab.jh.bakjoon.구현.세훈이의_선물가게_17225;

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
                        "0 0 3\n" +
                                "1 B 3\n" +
                                "4 R 2\n" +
                                "7 R 2",
                        "3\n" +
                                "1 2 3\n" +
                                "4\n" +
                                "4 5 6 7"
                ),
                Arguments.of(
                        "2 3 4\n" +
                                "1 B 3\n" +
                                "4 R 2\n" +
                                "6 B 2\n" +
                                "12 R 1",
                        "5\n" +
                                "1 2 4 5 7\n" +
                                "3\n" +
                                "3 6 8"
                ),
                Arguments.of(
                        "10 10 3\n" +
                                "10 B 1\n" +
                                "12 B 1\n" +
                                "15 R 1",
                        "2\n" +
                                "1 3\n" +
                                "1\n" +
                                "3"
                )
        );
    }
}
