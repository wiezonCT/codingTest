package lab.jh.bakjoon.구현.되돌리기_1360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Problem: 되돌리기
 * Number: 1360
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/1360
 *
 * @author 이종현
 * @date 2026-03-21
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
    static List<Text> texts;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        texts = new ArrayList<>();
        texts.add(new Text("", 0));
    }

    private static void solve() throws IOException {
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String type = st.nextToken();

            if (type.equals("type")) {
                char c = st.nextToken().charAt(0);
                int time = Integer.parseInt(st.nextToken());

                String prev = texts.get(i).text;
                texts.add(new Text(prev + c, time));
                continue;
            }

            int t = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            int undoTime = time - t;
            String undoText = "";

            for (int j = texts.size() - 1; j >= 0; j--) {
                if (texts.get(j).time < undoTime) {
                    undoText = texts.get(j).text;
                    break;
                }
            }

            texts.add(new Text(undoText, time));
        }

        System.out.print(texts.get(texts.size() - 1).text);
    }

    static class Text {
        String text;
        int time;

        Text(String text, int time) {
            this.text = text;
            this.time = time;
        }
    }
}
