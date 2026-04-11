package lab.jh.bakjoon.구현.세훈이의_선물가게_17225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Problem: 세훈이의 선물가게
 * Number: 17225
 * Tier: Silver?
 * Link: https://www.acmicpc.net/problem/17225
 *
 * @author 이종현
 * @date 2026-04-08
 * @category 구현
 * @description
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int a, b, n;
    static List<Integer> sm, js;

    static PriorityQueue<Present> pq;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        pq = new PriorityQueue<>();
        sm = new ArrayList<>();
        js = new ArrayList<>();

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int smTime = 0, jsTime = 0; // 상민이와 지수가 작업이 가능한 시간
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            int m = Integer.parseInt(st.nextToken());

            if (c == 'B') {
                smTime = Math.max(smTime, t); // 상민이의 작업 가능 시간과 주문한 시간 중 큰 값부터 작업 시작
                for (int j = 0; j < m; j++) {
                    pq.add(new Present(smTime, c));
                    smTime += a;
                }
                continue;
            }

            // 지수는
            jsTime = Math.max(jsTime, t); // 동일하게 작업 가능 시간과 주문한 시간 중 큰 값부터 작업 시작
            for (int j = 0; j < m; j++) {
                pq.add(new Present(jsTime, c));
                jsTime += b;
            }
        }
    }

    private static void solve() {
        // 입력받을 때 정렬을 다 해놨으니 꺼내면서 index만 붙여주기
        int index = 1;
        List<Integer> sm = new ArrayList<>();
        List<Integer> js = new ArrayList<>();

        while (!pq.isEmpty()) {
            Present p = pq.poll();

            if (p.type == 'B') {
                sm.add(index++);
                continue;
            }

            js.add(index++);
        }

        print(sm, js);
    }

    private static void print(List<Integer> sm, List<Integer> js) {
        StringBuilder sb = new StringBuilder();
        sb.append(sm.size()).append("\n");
        for (int i = 0; i < sm.size(); i++) {
            sb.append(sm.get(i)).append(" ");
        }
        sb.append("\n").append(js.size()).append("\n");
        for (int i = 0; i < js.size(); i++) {
            sb.append(js.get(i)).append(" ");
        }

        System.out.print(sb);
    }

    static class Present implements Comparable<Present> {
        int time;
        char type;

        public Present(int time, char type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Present o) {
            // 시간이 같으면 상민 'B' 가 지수 'R' 보다 우선 아스키 코드로 'B'가 'R' 보다 작아서 해당 로직
            if (this.time == o.time) {
                return this.type - o.type;
            }

            return this.time - o.time;
        }
    }
}
