package lab.jh.bakjoon.구현.체스_1986;

import lab.common.BojTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class 체스_1986_테스트 extends BojTestBase {
    @Override
    protected Class<?> getSolutionClass() {
        return 체스_1986.class;
    }

    @Override
    protected Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "4 4\n" +
                        "2 1 4 2 4\n" +
                        "1 1 2\n" +
                        "1 2 3",
                        "6"
                ),
                Arguments.of(
                        "2 3\n" +
                                "1 1 2\n" +
                                "1 1 1\n" +
                                "0",
                        "0"
                )
        );
    }
}
