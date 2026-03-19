package lab.jh.bakjoon.구현.체스_1986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Problem: 체스
 * Number: 1986
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/1986
 *
 * @author 이종현
 * @date 2026-03-19
 * @category 구현
 * @memory 18260 KB
 * @time  132 ms
 * @description
 * 구현이라 기능적 개선보다는 코드 가독성 중심으로 리팩토링
 */
public class 체스_1986_리팩토링 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m;
    static int[][] map;
    static List<Pos> posList;

    static final int SAFE = 0;
    static final int ATTACKED = 1;
    static final int PIECE = 2;

    static final int QUEEN = 0;
    static final int KNIGHT = 1;
    static final int PAWN = 2;

    static final int[][] QUEEN_MOVES = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    static final int[][] KNIGHT_MOVES = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        posList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        initHelper(QUEEN);
        initHelper(KNIGHT);
        initHelper(PAWN);
    }

    private static void initHelper(int type) throws IOException {
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            posList.add(new Pos(y, x, type));
            map[y][x] = PIECE;
        }
    }

    private static void solve() {
        for (Pos p : posList) {
            moveEachType(p);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == SAFE) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }

    private static void moveEachType(Pos pos) {
        switch (pos.type) {
            case QUEEN:
                moveQueen(pos.y, pos.x);
                break;
            case KNIGHT:
                moveKnight(pos.y, pos.x);
                break;
        }
    }

    private static void moveQueen(int y, int x) {
        for (int[] d : QUEEN_MOVES) {
            int dy = y + d[0];
            int dx = x + d[1];

            while (dy < n && dy >= 0 && dx < m && dx >= 0) {
                if (map[dy][dx] == PIECE) {
                    break;
                }

                map[dy][dx] = ATTACKED;
                dy += d[0];
                dx += d[1];
            }
        }
    }

    private static void moveKnight(int y, int x) {
        for (int[] d : KNIGHT_MOVES) {
            int dy = y + d[0];
            int dx = x + d[1];

            if (dy < 0 || dy >= n || dx < 0 || dx >= m) {
                continue;
            }

            if (map[dy][dx] != PIECE) {
                map[dy][dx] = ATTACKED;
            }
        }
    }

    static class Pos {
        // type : 0 퀸, 1 나이트, 2 폰
        int y, x, type;

        public Pos(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}
