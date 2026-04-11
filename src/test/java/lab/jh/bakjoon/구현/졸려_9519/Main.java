package lab.jh.bakjoon.구현.졸려_9519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Problem: 졸려
 * Number: 9519
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/9519
 *
 * @author 이종현
 * @date 2026-04-11
 * @category 구현
 * @description
 */
public class Main {
    private static BufferedReader br;
    private static StringTokenizer st;

    static int x;
    static String word;
    static boolean isOdd;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(br.readLine());
        word = br.readLine();
        isOdd = word.length() % 2 != 0;
    }

    private static void solve() {
        List<String> cycles = new ArrayList<>();
        cycles.add(word); // 0번은 무시

        int cycle = word.length();
        String newWord = word;
        for (int i = 1; i <= x; i++) {
            newWord = returnWord(newWord);
            cycles.add(newWord);
            if (newWord.equals(word)) {
                cycle = i;
                break;
            }
        }
        System.out.print(cycles.get(x % cycle));
    }

    private static String returnWord(String word) {
        int len = word.length();

        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < len; i += 2) {
            newWord.append(word.charAt(i));
        }

        if (isOdd) {
            len -= 2;
        } else {
            len -= 1;
        }

        for (int i = len; i > 0; i -= 2) {
            newWord.append(word.charAt(i));
        }

        return newWord.toString();
    }
}
