package lab.jh.bakjoon.구현.추월_2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Problem: 추월
 * Number: 2002
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/2002
 *
 * @author 이종현
 * @date 2026-04-12
 * @category 구현
 * @description
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n;
    static Map<String, Integer> dg;
    static int[] ys;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        dg = new HashMap<>();

        n = Integer.parseInt(br.readLine());
        ys = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dg.put(br.readLine(), i);
        }

        for (int i = 1; i <= n; i++) {
            ys[i] = dg.get(br.readLine());
        }
    }

    private static void solve() {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (ys[i] > ys[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}
