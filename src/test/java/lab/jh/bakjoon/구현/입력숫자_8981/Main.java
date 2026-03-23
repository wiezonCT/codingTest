package lab.jh.bakjoon.구현.입력숫자_8981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem: 입력숫자
 * Number: 8981
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/8981
 *
 * @author 이종현
 * @date 2026-03-23
 * @category 구현
 * @memory  MB
 * @time  ms
 * @description
 *
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n;
    static int[] y, x;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        y = new int[n];
        x = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        int count = 0;
        int curr = 0;

        while (count < n) {
            while (x[curr] != 0) {
                curr = (curr + 1) % n;
            }

            x[curr] = y[count];

            curr = (curr + x[curr]) % n;

            count++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(n).append("\n");
        for (int i = 0; i < n; i++) {
            sb.append(x[i]).append(" ");
        }
        System.out.println(sb);
    }
}
