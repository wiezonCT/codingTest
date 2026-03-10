package lab.jh.bakjoon.우선순위큐.맥주_축제_17503;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
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
 * @memory 81564 KB
 * @time 824 ms
 * @description
 *
 */
public class Refactor_맥주_축제_17503 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m, k;
    static PriorityQueue<Beer> beers = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            beers.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    private static void solve() {
        PriorityQueue<LikeBeer> likeBeers = new PriorityQueue<>();

        int count = 0;
        int currentDegree = 0;
        long likeCount = 0;

        while (!beers.isEmpty()) {
            Beer beer = beers.poll();

            likeBeers.offer(new LikeBeer(beer.like, beer.degree));
            count++;
            likeCount += beer.like;
            currentDegree = beer.degree;

            if (count == n) {
                if (likeCount >= m) {
                    break;
                }

                if (!beers.isEmpty()) {
                    LikeBeer likeBeer = likeBeers.poll();
                    count--;
                    likeCount -= likeBeer.like;
                }
            }
        }

        if (likeCount >= m) {
            System.out.print(currentDegree);
            return;
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

    static class LikeBeer implements Comparable<LikeBeer> {
        int like, degree;

        public LikeBeer(int like, int degree) {
            this.like = like;
            this.degree = degree;
        }

        @Override
        public int compareTo(LikeBeer o) {
            return this.like - o.like;
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
        beers = new PriorityQueue<>();
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

        Refactor_맥주_축제_17503.main(new String[]{});

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