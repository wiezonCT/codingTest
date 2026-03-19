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
 * @memory 18376 KB
 * @time 132 ms
 * @description
 *
 */
public class 체스_1986 {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m;
    static int[][] map;
    static List<Pos> posList;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (Pos p : posList) {
            moveEachType(p);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }

    private static void moveEachType(Pos pos) {
        switch (pos.type) {
            case 0:
                moveQueen(pos.y, pos.x);
                break;
            case 1:
                moveKnight(pos.y, pos.x);
                break;
        }
    }

    private static void moveQueen(int y, int x) {
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dd : d) {
            int dy = y + dd[0];
            int dx = x + dd[1];

            while (dy < n && dy >= 0 && dx < m && dx >= 0) {
                if (map[dy][dx] == 2) {
                    break;
                }

                map[dy][dx] = 1;
                dy += dd[0];
                dx += dd[1];
            }
        }
    }

    private static void moveKnight(int y, int x) {
        int[][] d = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};

        for (int[] dd : d) {
            int dy = y + dd[0];
            int dx = x + dd[1];

            if (dy < 0 || dy >= n || dx < 0 || dx >= m) {
                continue;
            }

            if (map[dy][dx] != 2) {
                map[dy][dx] = 1;
            }
        }
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        posList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int count;
        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            posList.add(new Pos(y, x, 0));
            map[y][x] = 2;
        }

        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            posList.add(new Pos(y, x, 1));
            map[y][x] = 2;
        }

        st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            posList.add(new Pos(y, x, 2));
            map[y][x] = 2;
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
