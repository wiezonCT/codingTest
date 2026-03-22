package lab.jh.bakjoon.구현.봄버맨_16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: 봄버맨
 * Number: 16918
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/16918
 *
 * @author 이종현
 * @date 2026-03-22
 * @category 구현
 * @memory  MB
 * @time  ms
 * @description
 *
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int r, c, n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == 'O' ? 0 : -1;
            }
        }
    }

    private static void solve() {
        // 0 ~ 1초는 아무것도 안함
        int time = 1;

        while (time < n) {
            time++;
            installBomb(time);

            if (time == n) {
                break;
            }

            time++;
            bomb(time);
        }
    }

    // 폭탄 설치 (2, 4, 6 초)
    private static void installBomb(int time) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = time;
                }
            }
        }
    }

    // 폭파 (3, 5, 7 초)
    private static void bomb(int time) {
        int[] d = {-1, 1, 0, 0};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = map[i][j];

                if (map[i][j] == -1 || time - temp != 3) {
                    continue;
                }

                map[i][j] = -1;

                for (int k = 0; k < 4; k++) {
                    int dy = i + d[k];
                    int dx = j + d[3 - k];

                    if (dy < 0 || dy >= r || dx < 0 || dx >= c || map[dy][dx] == temp) {
                        continue;
                    }

                    map[dy][dx] = -1;
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    sb.append('.');
                    continue;
                }

                sb.append('O');
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
