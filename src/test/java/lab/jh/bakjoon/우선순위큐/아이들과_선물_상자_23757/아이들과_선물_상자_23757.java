package lab.jh.bakjoon.우선순위큐.아이들과_선물_상자_23757;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Problem: 아이들과 선물 상자
 * Number: 23757
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/23757
 *
 * @author 이종현
 * @date 2026-03-16
 * @category 우선순위 큐
 * @memory 36260 KB
 * @time 468 ms
 * @description
 *
 */
public class 아이들과_선물_상자_23757 {

    private static final Logger log = LoggerFactory.getLogger(아이들과_선물_상자_23757.class);
    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m;
    static int[] kids;
    static PriorityQueue<Integer> presents;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        presents = new PriorityQueue<>(Collections.reverseOrder());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        kids = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            presents.offer(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            kids[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        System.out.print(bfs(0));
    }

    private static int bfs(int count) {
        int idx = -1;

        while (!presents.isEmpty() && idx < m - 1) {
            int present = presents.poll();
            int kid = kids[++idx];

            if (present > kid) {
                count++;
                presents.offer(present - kid);
            } else if (kids[idx] == present) {
                count++;
            } else {
                return 0;
            }
        }

        return count == m ? 1 : 0;
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
                        "4 4\n" +
                                "4 3 2 1\n" +
                                "3 1 2 1",
                        "1"
                ),
                Arguments.of(
                        "4 3\n" +
                                "4 3 2 1\n" +
                                "3 1 5",
                        "0"
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

        아이들과_선물_상자_23757.main(new String[]{});

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
