package lab.jh.bakjoon.구현.아스키_도형_3495;

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
                        "4 4\n" +
                                "/\\/\\\n" +
                                "\\../\n" +
                                ".\\.\\\n" +
                                "..\\/",
                        "8"
                )
        );
    }
}
