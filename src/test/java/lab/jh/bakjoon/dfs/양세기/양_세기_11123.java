package lab.jh.bakjoon.dfs.양세기;

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
 * Problem: 양 한마리... 양 두마리...
 * Number: 11123
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/11123
 *
 * @author 이종현
 * @date 2026-03-08
 * @category DFS
 * @memory 20580 KB
 * @time  192 ms
 * @description
 * 크게 고칠 거 없는듯?
 */
public class 양_세기_11123 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int t, h, w;
    static char[][] map;
    static int[] d = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            init();
            sb.append(solve()).append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            String line = br.readLine();
            for (int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }

    private static int solve() {
        int answer = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '#') {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void dfs(int y, int x) {
        map[y][x] = '.';

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3 - i];

            if (dy >= h || dy < 0 || dx >= w || dx < 0) continue;

            if (map[dy][dx] == '.') continue;

            dfs(dy, dx);
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
                        "2\n" +
                                "4 4\n" +
                                "#.#.\n" +
                                ".#.#\n" +
                                "#.##\n" +
                                ".#.#\n" +
                                "3 5\n" +
                                "###.#\n" +
                                "..#..\n" +
                                "#.###",
                        "6\n" +
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

        양_세기_11123.main(new String[]{});

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
