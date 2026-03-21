package lab.jh.bakjoon.구현.되돌리기_1360;

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
                                "type a 1\n" +
                                "type b 2\n" +
                                "type c 3\n" +
                                "undo 3 5",
                        "a"
                ),
                Arguments.of(
                        "4\n" +
                                "type a 1\n" +
                                "type b 2\n" +
                                "undo 2 3\n" +
                                "undo 2 4",
                        "a"
                ),
                Arguments.of(
                        "3\n" +
                                "type a 1\n" +
                                "undo 1 2\n" +
                                "undo 1 3",
                        "a"
                ),
                Arguments.of(
                        "4\n" +
                                "type a 1\n" +
                                "type b 2\n" +
                                "type c 3\n" +
                                "undo 10 1000",
                        "abc"
                ),
                Arguments.of(
                        "1\n" +
                                "undo 1 1",
                        ""
                )
        );
    }
}
