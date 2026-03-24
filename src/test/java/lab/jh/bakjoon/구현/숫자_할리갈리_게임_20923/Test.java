package lab.jh.bakjoon.구현.숫자_할리갈리_게임_20923;

import lab.common.BojTestBase;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Test extends BojTestBase {
    @Override
    protected Class<?> getSolutionClass() {
        return Refactor.class;
    }

    @Override
    protected Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "10 12\n" +
                                "1 2\n" +
                                "2 2\n" +
                                "1 2\n" +
                                "2 3\n" +
                                "3 1\n" +
                                "2 2\n" +
                                "2 5\n" +
                                "2 1\n" +
                                "5 1\n" +
                                "2 3",
                        "do"
                ),
                Arguments.of(
                        "1 1\n" +
                                "5 2",
                        "su"
                ),
                Arguments.of(
                        "3 4\n" +
                                "1 2\n" +
                                "2 2\n" +
                                "1 1",
                        "dosu"
                )
        );
    }
}
