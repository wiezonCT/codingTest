package lab.jh.bakjoon.이분탐색;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Problem: 히오스 프로게이머
 * Number: 16564
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/16564
 *
 * @author 이종현
 * @date 2026-03-18
 * @category 바이너리
 * @memory 26876 KB
 * @time 332 ms
 * @description
 * 1. 조금 백트래킹을.. 미세하게 빨라지네
 */
public class Refactor_히오스_프로게이머_16564 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, k;
    static int[] levels;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        levels = new int[n];

        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(levels);
    }

    private static void solve() {
        System.out.print(binarySearch());
    }

    private static long binarySearch() {
        int l = levels[0];
        int r = l + k;

        long answer = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(mid)) {
                answer = mid;
                l = mid + 1;
                continue;
            }

            r = mid - 1;
        }

        return answer;
    }

    private static boolean isPossible(int mid) {
        long temp = 0;

        for (int level : levels) {
            if (level >= mid) {
                break;
            }

            temp += mid - level;

            if (temp > k) {
                return false;
            }
        }

        return true;
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
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        "3 10\n" +
                                "10\n" +
                                "20\n" +
                                "15",
                        "17"
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

        Refactor_히오스_프로게이머_16564.main(new String[]{});

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
