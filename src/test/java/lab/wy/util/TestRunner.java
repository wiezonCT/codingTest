package lab.wy.util;

import org.awaitility.core.ThrowingRunnable;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestRunner {

    public static void run(TestCase testCase, ThrowingRunnable solve) throws Throwable {
        System.setIn(new ByteArrayInputStream(testCase.input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            long beforeMem = getUsedMemoryMB();
            long start = System.currentTimeMillis();

            solve.run();

            long end = System.currentTimeMillis();
            long afterMem = getUsedMemoryMB();

            long timeUsed = end - start;
            long memoryUsed = afterMem - beforeMem;

            String result = outContent.toString().trim();

            System.setOut(originalOut);
            // 시간 체크
            if (timeUsed > testCase.timeLimitMs) {
                throw new AssertionError(
                        "시간 제한 초과\n" +
                                "문제 제한 시간=" + testCase.timeLimitMs + "ms, 실제 시간 =" + timeUsed + "ms"
                );
            }

            // 메모리 체크
            if (memoryUsed > testCase.memoryLimitMb) {
                throw new AssertionError(
                        "메모리 제한 초과\n" +
                                "문제 메모리 제한 =" + testCase.memoryLimitMb + "MB, 실제 메모리 =" + memoryUsed + "MB"
                );
            }

            // 결과 체크
            Assertions.assertEquals(
                    testCase.expected.trim(),
                    result,
                    "\n[입력값]\n" + testCase.input +
                            "\n[예상 결과값]\n" + testCase.expected +
                            "\n[실제 결과값]\n" + result +
                            "\n[소요 시간] : " + timeUsed + "ms" +
                            "\n[메모리 사용률] : " + memoryUsed + "MB"
            );

            System.out.println(
                    "\n ========= [PASS] =========" +
                            "\n[입력값] :\n" + testCase.input +
                            "\n[출력값] :\n" + result +
                            "\n ========================="
            );

        } finally {
            System.setOut(originalOut);
        }
    }

    private static long getUsedMemoryMB() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        return (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
    }
}
