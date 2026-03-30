package lab.jh.bakjoon.구현.샤워실_바닥_깔기_14600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem: 샤워실 바닥 깔기
 * Number: 14600
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/14600
 *
 * @author 이종현
 * @date 2026-03-30
 * @category 구현
 * @description
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int k, n;
    static int[][] map;
    static int depth;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        n = (int) Math.pow(2, k);
        map = new int[n][n];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[n - y][x - 1] = -1;
        depth = 1;
    }


    private static void solve() {
        divide(0, 0, n);
    }

    private static void divide(int y, int x, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int cur = depth++;

        if (notHole(y, x, half)) {
            map[y + half - 1][x + half - 1] = cur;
        }
        if (notHole(y, x + half, half)) {
            map[y + half - 1][x + half] = cur;
        }
        if (notHole(y + half, x, half)) {
            map[y + half][x + half - 1] = cur;
        }
        if (notHole(y + half, x + half, half)) {
            map[y + half][x + half] = cur;
        }

        divide(y, x, half);
        divide(y + half, x, half);
        divide(y, x + half, half);
        divide(y + half, x + half, half);
    }

    private static boolean notHole(int y, int x, int size) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
