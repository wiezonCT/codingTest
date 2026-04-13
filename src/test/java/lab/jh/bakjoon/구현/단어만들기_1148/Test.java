package lab.jh.bakjoon.구현.단어만들기_1148;

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
                        "APPLE\n" +
                                "BANANA\n" +
                                "BANE\n" +
                                "BRILLIANT\n" +
                                "LINT\n" +
                                "PALE\n" +
                                "PROBLEM\n" +
                                "TILL\n" +
                                "TRILL\n" +
                                "-\n" +
                                "LARBITNLI\n" +
                                "LEPAPBNNA\n" +
                                "LEPAPBNAM\n" +
                                "#",
                        "AB 1 ILT 4\n" +
                                "BN 1 AE 3\n" +
                                "M 0 AE 3"
                )
        );
    }
}
