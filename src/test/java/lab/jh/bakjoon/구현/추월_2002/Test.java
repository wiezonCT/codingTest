package lab.jh.bakjoon.구현.추월_2002;

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
                        "4\n" +
                                "ZG431SN\n" +
                                "ZG5080K\n" +
                                "ST123D\n" +
                                "ZG206A\n" +
                                "ZG206A\n" +
                                "ZG431SN\n" +
                                "ZG5080K\n" +
                                "ST123D",
                        "1"
                ),
                Arguments.of(
                        "5\n" +
                                "ZG508OK\n" +
                                "PU305A\n" +
                                "RI604B\n" +
                                "ZG206A\n" +
                                "ZG232ZF\n" +
                                "PU305A\n" +
                                "ZG232ZF\n" +
                                "ZG206A\n" +
                                "ZG508OK\n" +
                                "RI604B",
                        "3"
                ),
                Arguments.of(
                        "5\n" +
                                "ZG206A\n" +
                                "PU234Q\n" +
                                "OS945CK\n" +
                                "ZG431SN\n" +
                                "ZG5962J\n" +
                                "ZG5962J\n" +
                                "OS945CK\n" +
                                "ZG206A\n" +
                                "PU234Q\n" +
                                "ZG431SN",
                        "2"
                )
        );
    }
}
