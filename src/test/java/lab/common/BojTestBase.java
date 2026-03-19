package lab.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BojTestBase {

    private ByteArrayOutputStream outputStreamCaptor;
    private final PrintStream standardOut = System.out;

    protected abstract Class<?> getSolutionClass();

    protected abstract Stream<Arguments> provideTestCases();

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest(name = "{index}번째 예제 테스트")
    @MethodSource("provideTestCases")
    void executeTest(String input, String expectedOutput) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Runtime.getRuntime().gc();

        long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        Method mainMethod = getSolutionClass().getMethod("main", String[].class);
        mainMethod.invoke(null, (Object) new String[]{});

        long endTime = System.currentTimeMillis();
        long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long timeElapsed = endTime - startTime;
        long memoryUsed = (afterMemory - beforeMemory) / 1024;

        System.err.printf("[측정 결과] 시간: %d ms, 메모리: %d KB%n", timeElapsed, memoryUsed);

        Assertions.assertEquals(
                expectedOutput.trim(),
                outputStreamCaptor.toString().trim().replace("\r\n", "\n")
        );
    }
}