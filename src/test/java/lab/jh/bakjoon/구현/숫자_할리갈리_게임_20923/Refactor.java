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
 * @Description
 * - 코드 정리만
 *
 */
public class Refactor {

    private static BufferedReader br;
    private static StringTokenizer st;

    static int n, m;
    static Deque<Integer> dodo;
    static Deque<Integer> sy;
    static Deque<Integer> dodoGround;
    static Deque<Integer> syGround;

    // 상태를 명확하게 관리하기 위한 Enum 도입
    enum Winner {
        DODO, SY, CONTINUE
    }

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
        boolean isDodoTurn = true;

        for (int turn = 0; turn < m; turn++) {
            if (isDodoTurn) {
                dodoGround.addLast(dodo.removeLast());
            } else {
                syGround.addLast(sy.removeLast());
            }

            if (dodo.isEmpty() || sy.isEmpty()) {
                break;
            }

            int dodoTop = dodoGround.isEmpty() ? 0 : dodoGround.peekLast();
            int syTop = syGround.isEmpty() ? 0 : syGround.peekLast();

            Winner winner = checkWinner(dodoTop, syTop);

            if (winner != Winner.CONTINUE) {
                takeCards(winner);
            }

            isDodoTurn = !isDodoTurn;
        }

        printResult();
    }

    private static Winner checkWinner(int dodoCard, int syCard) {
        if (dodoCard + syCard == 5 && dodoCard != 0 && syCard != 0) {
            return Winner.SY;
        } else if (dodoCard == 5 || syCard == 5) {
            return Winner.DODO;
        }
        return Winner.CONTINUE;
    }

    private static void takeCards(Winner winner) {
        if (winner == Winner.DODO) {
            while (!syGround.isEmpty()) dodo.addFirst(syGround.removeFirst());
            while (!dodoGround.isEmpty()) dodo.addFirst(dodoGround.removeFirst());
        } else if (winner == Winner.SY) {
            while (!dodoGround.isEmpty()) sy.addFirst(dodoGround.removeFirst());
            while (!syGround.isEmpty()) sy.addFirst(syGround.removeFirst());
        }
    }

    private static void printResult() {
        int dodoSize = dodo.size();
        int sySize = sy.size();

        if (dodoSize > sySize) {
            System.out.println("do");
        } else if (dodoSize < sySize) {
            System.out.println("su");
        } else {
            System.out.println("dosu");
        }
    }
}