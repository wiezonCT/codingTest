package lab.jh.bakjoon.구현.단어만들기_1148;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Problem: 단어만들기
 * Number: 1148
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/1148
 *
 * @author 이종현
 * @date 2026-04-13
 * @category 구현
 * @description
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static List<int[]> dictionary;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        dictionary = new ArrayList<>();

        while (true) {
            String line = br.readLine();

            if (line.equals("-")) {
                break;
            }

            int[] counts = new int[26];

            for (int i = 0; i < line.length(); i++) {
                counts[line.charAt(i) - 'A']++;
            }

            dictionary.add(counts);
        }
    }

    private static void solve() throws IOException {
        while (true) {
            String line = br.readLine();

            if (line.equals("#")) {
                break;
            }

            canMakeWord(line);
        }

        System.out.print(sb);
    }

    private static void canMakeWord(String puzzle) {
        int[] puzzleCounts = new int[26];
        boolean[] visited = new boolean[26];

        for (char c : puzzle.toCharArray()) {
            puzzleCounts[c - 'A']++;
            visited[c - 'A'] = true;
        }

        int[] realCounts = new int[26];

        for (int[] wordCounts : dictionary) {
            boolean canMake = true;

            for (int i = 0; i < 26; i++) {
                if (wordCounts[i] > puzzleCounts[i]) {
                    canMake = false;
                    break;
                }
            }

            if (canMake) {
                for (int i = 0; i < 26; i++) {
                    if (wordCounts[i] > 0) {
                        realCounts[i]++;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            if (visited[i]) {
                if (realCounts[i] < min) {
                    min = realCounts[i];
                }
                if (realCounts[i] > max) {
                    max = realCounts[i];
                }
            }
        }

        StringBuilder minSb = new StringBuilder();
        StringBuilder maxSb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            if (visited[i]) {
                if (realCounts[i] == min) {
                    minSb.append((char) ('A' + i));
                }
                if (realCounts[i] == max) {
                    maxSb.append((char) ('A' + i));
                }
            }
        }

        sb.append(minSb).append(" ").append(min).append(" ").append(maxSb).append(" ").append(max).append("\n");
    }
}
