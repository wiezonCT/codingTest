package lab.jh.bakjoon.구현.과일_탕후루;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Problem: 과일 탕후루
 * Number: 30804
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/30804
 *
 * @author 이종현
 * @date 2026-03-09
 * @category 구현
 * @memory 30236 KB
 * @time 296 ms
 * @description
 * 1. Map, Set은 무거우니 배열로 단순화
 * 2. Map을 매번 순회하며 Count하는건 비효율적이므로 l, r로 개수 충분히 구할 수 있음 ...
 * 3. 이중 반복 없애기
 */
public class Refactor_과일_탕후루_30804 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n;
    static int answer = -1;
    static int[] tanghulu;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        tanghulu = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            tanghulu[i] = number;
        }
    }

    private static void solve() {
        slidingWindow();
    }

    private static void print() {
        System.out.print(answer);
    }

    private static void slidingWindow() {
        int l = 0, r = 0;
        int distinctCount = 0;
        int[] fruitCounts = new int[10];

        while (r < n) {
            int right = tanghulu[r++];

            if (fruitCounts[right] == 0) {
                distinctCount++;
            }
            fruitCounts[right]++;

            if (distinctCount > 2) {
                int left = tanghulu[l++];
                fruitCounts[left]--;

                if (fruitCounts[left] == 0) {
                    distinctCount--;
                }
            }
        }

        answer = r - l;
    }

    // ==========================================================
    // 여기서부터는 로컬 테스트용 코드
    // ==========================================================
    private ByteArrayOutputStream outputStreamCaptor;
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        answer = -1;
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "5\n" +
                                "5 1 1 2 1",
                        "4"
                ),
                Arguments.of(
                        "3\n" +
                                "1 1 1",
                        "3"
                ),
                Arguments.of(
                        "9\n" +
                                "1 2 3 4 5 6 7 8 9",
                        "2"
                ),
                Arguments.of(
                        "1\n" +
                                "2",
                        "1"
                ),
                Arguments.of(
                        "8\n" +
                                "1 2 1 2 3 3 3 3",
                        "5"
                ),
                Arguments.of(
                        "10\n" +
                                "7 5 5 2 4 2 2 5 5 5",
                        "5"
                ),
                Arguments.of(
                        "6\n" +
                                "7 2 3 2 7 5\n",
                        "3"
                )
        );
    }

    @ParameterizedTest(name = "{index}번째 예제 테스트")
    @MethodSource("provideTestCases")
    void test(String input, String expectedOutput) throws Exception {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 1. 측정 전 가비지 컬렉터(GC) 실행 (최대한 찌꺼기 메모리 정리)
        Runtime.getRuntime().gc();

        // 2. 시작 전 메모리 및 시간 기록
        long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        Refactor_과일_탕후루_30804.main(new String[]{});

        // 3. 종료 후 메모리 및 시간 기록
        long endTime = System.currentTimeMillis();
        long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // 4. 결과 계산 (ms, KB 단위로 변환)
        long timeElapsed = endTime - startTime;
        long memoryUsed = (afterMemory - beforeMemory) / 1024; // Byte -> KB

        System.err.printf("[측정 결과] 시간: %d ms, 메모리: %d KB%n", timeElapsed, memoryUsed);

        Assertions.assertEquals(
                expectedOutput.trim(),
                outputStreamCaptor.toString().trim().replace("\r\n", "\n")
        );
    }
}
