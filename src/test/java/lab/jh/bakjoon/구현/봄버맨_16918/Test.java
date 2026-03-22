package lab.jh.bakjoon.구현.봄버맨_16918;

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
                        "6 7 3\n" +
                                ".......\n" +
                                "...O...\n" +
                                "....O..\n" +
                                ".......\n" +
                                "OO.....\n" +
                                "OO.....",
                        "OOO.OOO\n" +
                                "OO...OO\n" +
                                "OOO...O\n" +
                                "..OO.OO\n" +
                                "...OOOO\n" +
                                "...OOOO"
                ), Arguments.of(
                        "6 7 4\n" +
                                ".......\n" +
                                "...O...\n" +
                                "....O..\n" +
                                ".......\n" +
                                "OO.....\n" +
                                "OO.....",
                        "OOOOOOO\n" +
                                "OOOOOOO\n" +
                                "OOOOOOO\n" +
                                "OOOOOOO\n" +
                                "OOOOOOO\n" +
                                "OOOOOOO"
                ), Arguments.of(
                        "6 7 5\n" +
                                ".......\n" +
                                "...O...\n" +
                                "....O..\n" +
                                ".......\n" +
                                "OO.....\n" +
                                "OO.....",
                        ".......\n" +
                                "...O...\n" +
                                "....O..\n" +
                                ".......\n" +
                                "OO.....\n" +
                                "OO....."
                )
        );
    }
}
