package lab.jh.bakjoon.구현.숫자_할리갈리_게임_20923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem: 숫자 할리갈리 게임
 * Number: 20923
 * Tier: Silver
 * Link: https://www.acmicpc.net/problem/20923
 *
 * @author 이종현
 * @date 2026-03-24
 * @category 구현
 * @memory  MB
 * @time  ms
 * @description
 *
 */
public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m;
    static Deque<Integer> dodo;
    static Deque<Integer> sy;
    static Deque<Integer> dodoGround;
    static Deque<Integer> syGround;


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dodo = new ArrayDeque<>();
        sy = new ArrayDeque<>();
        dodoGround = new ArrayDeque<>();
        syGround = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dodo.add(Integer.parseInt(st.nextToken()));
            sy.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        int count = 0;
        boolean isDodoTurn = true;

        while (count++ < m) {
            if (isDodoTurn) {
                dodoGround.addLast(dodo.removeLast());
            } else {
                syGround.addLast(sy.removeLast());
            }

            if (dodo.isEmpty() || sy.isEmpty()) {
                break;
            }

            int dodoTop = dodoGround.isEmpty() ? 0 : dodoGround.getLast();
            int syTop = syGround.isEmpty() ? 0 : syGround.getLast();

            String winner = isWhoWinner(dodoTop, syTop);

            if (!winner.equals("CONTINUE")) {
                setWinnerDeque(winner);
            }

            isDodoTurn = !isDodoTurn;
        }

        int dodoSize = dodo.size();
        int sySize = sy.size();

        if (dodoSize == sySize) {
            System.out.print("dosu");
        } else if (dodoSize > sySize) {
            System.out.print("do");
        } else {
            System.out.print("su");
        }
    }

    private static String isWhoWinner(int dodoCard, int syCard) {
        if (dodoCard + syCard == 5 && !(dodoCard == 0 || syCard == 0)) {
            return "SY";
        } else if (dodoCard == 5 || syCard == 5) {
            return "DODO";
        }

        return "CONTINUE";
    }

    private static void setWinnerDeque(String winner) {
        switch (winner) {
            case "DODO":
                while (!syGround.isEmpty()) {
                    dodo.addFirst(syGround.remove());
                }
                while (!dodoGround.isEmpty()) {
                    dodo.addFirst(dodoGround.remove());
                }
                break;
            case "SY":
                while (!dodoGround.isEmpty()) {
                    sy.addFirst(dodoGround.remove());
                }
                while (!syGround.isEmpty()) {
                    sy.addFirst(syGround.remove());
                }
                break;
        }
    }
}
