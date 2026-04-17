package lab.jh.bakjoon.구현.아스키_도형_3495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem: 아스키 도형
 * Number: 3495
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/3495
 *
 * @author 이종현
 * @date 2026-04-15
 * @category 구현
 * @description
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int h, w;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    private static void solve() {
        int area = 0;

        for (int i = 0; i < h; i++) {
            boolean isInner = false;
            for (char c : map[i]) {
                if (c == '.') {
                    if (isInner) {
                        area++;
                    }
                }

                if (c == '\\' || c == '/') {
                    isInner = !isInner;

                    if (!isInner) {
                        area++;
                    }
                }
            }
        }

        System.out.print(area);
    }
}
