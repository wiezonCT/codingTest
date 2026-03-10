package lab.jh.bakjoon.우선순위큐.맥주_축제_17503;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Problem: 맥주 축제
 * Number: 17503
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/17503
 *
 * @author 이종현
 * @date 2026-03-10
 * @category 우선 순위 큐
 * @memory 76780 KB
 * @time 820 ms
 * @description
 * 1. 도수는 정렬만 해도 됐는데 왜 우선순위큐로 만들었을까 .. 없애기
 * 성능상 큰 차이는 없네
 */
public class 맥주_축제_17503 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m, k;
    static List<Beer> beers;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        beers = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            beers.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(beers);
    }

    private static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long likeSum = 0;
        int days = 0;

        for (Beer beer : beers) {
            pq.offer(beer.like);
            likeSum += beer.like;
            days++;

            if (pq.size() > n) {
                likeSum -= pq.poll();
                days--;
            }

            if (days == n && likeSum >= m) {
                System.out.print(beer.degree);
                return;
            }
        }

        System.out.print(-1);
    }

    static class Beer implements Comparable<Beer> {
        int like, degree;

        public Beer(int like, int degree) {
            this.like = like;
            this.degree = degree;
        }

        @Override
        public int compareTo(Beer o) {
            return this.degree - o.degree;
        }
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
                        "3 9 5\n" +
                                "2 5\n" +
                                "4 6\n" +
                                "3 3\n" +
                                "4 3\n" +
                                "1 4",
                        "5"
                ),
                Arguments.of(
                        "1 100 2\n" +
                                "99 10\n" +
                                "99 10",
                        "-1"
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

        맥주_축제_17503.main(new String[]{});

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