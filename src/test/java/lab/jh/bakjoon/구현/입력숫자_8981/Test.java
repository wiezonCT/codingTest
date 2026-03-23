package lab.jh.bakjoon.구현.입력숫자_8981;

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
                        "5\n" +
                                "1 2 4 3 5",
                        "5\n" +
                                "1 2 3 4 5"
                ),
                Arguments.of(
                        "10\n" +
                                "1 2 4 8 6 3 7 5 10 9",
                        "10\n" +
                                "1 2 3 4 5 6 7 8 9 10"
                ),
                Arguments.of(
                        "10\n" +
                                "5 5 7 4 33 10 9 3 2 6",
                        "10\n" +
                                "5 7 33 2 6 5 10 9 4 3"
                )
        );
    }
}
