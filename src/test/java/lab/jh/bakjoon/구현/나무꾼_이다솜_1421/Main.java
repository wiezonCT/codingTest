package lab.jh.bakjoon.구현.나무꾼_이다솜_1421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: 나무꾼 이다솜
 * Number: 1421
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/1421
 *
 * @author 이종현
 * @date 2026-03-28
 * @category 구현
 * @memory  MB
 * @time  ms
 * @description
 * 
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, c, w, maxCost = -1;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        trees = new int[n];

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            maxCost = Math.max(maxCost, trees[i]);
        }

        Arrays.sort(trees);
    }

    private static void solve() {
        long answer = 0;

        for (int i = 1; i <= maxCost; i++) {
            long sum = 0;

            for (int tree : trees) {
                long cost = 0;
                if (tree < i) {
                    continue;
                }

                if (tree % i == 0) {
                    cost = tree / i - 1;
                } else {
                    cost = tree / i;
                }

                if (tree == i) {
                    cost = (long) tree * w;
                } else {
                    cost = (long) (tree - tree % i) * w - cost * c;
                }

                if (cost > 0) {
                    sum += cost;
                }
            }

            answer = Math.max(answer, sum);
        }

        System.out.print(answer);
    }
}
