package lab.jh.bakjoon.구현.샤워실_바닥_깔기_14600;

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
                        "1\n" +
                                "2 2",
                        "1 -1\n" +
                                "1 1"
                ),
                Arguments.of(
                        "2\n" +
                                "1 1",
                        "4 4 5 5\n" +
                                "4 3 3 5\n" +
                                "1 1 3 2\n" +
                                "-1 1 2 2"
                ),
                Arguments.of(
                        "2\n" +
                                "3 2",
                        "4 4 5 5\n" +
                                "4 3 3 5\n" +
                                "1 3 -1 2\n" +
                                "1 1 2 2"
                )
        );
    }
}
