package lab.jh.programmers.LV2.숫자변환하기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Refactor {
    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 40;
        int n1 = 5;
        int answer1 = 2;
        int result1 = new Refactor().solution(x1, y1, n1);
        PRINT_RESULT(1, result1, answer1);

        int x2 = 10;
        int y2 = 40;
        int n2 = 30;
        int answer2 = 1;
        int result2 = new Refactor().solution(x2, y2, n2);
        PRINT_RESULT(2, result2, answer2);

        int x3 = 2;
        int y3 = 5;
        int n3 = 4;
        int answer3 = -1;
        int result3 = new Refactor().solution(x3, y3, n3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int x, int y, int n) {
        return dp(x, y, n);
    }

    private int dp(int x, int y, int n) {
        int[] dp = new int[y + 1];

        Arrays.fill(dp, y + 1);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == y + 1) continue;

            if (i + n <= y) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }

            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }

        return dp[y] == y + 1 ? -1 : dp[y];
    }
}