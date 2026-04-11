package lab.jh.bakjoon.구현.졸려_9519;

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
                        "4\n" +
                                "acefdb",
                        "abcdef"
                ),
                Arguments.of(
                        "1000\n" +
                                "aaaaaa",
                        "aaaaaa"
                ),
                Arguments.of(
                        "11\n" +
                                "srama",
                        "sarma"
                )
        );
    }
}
