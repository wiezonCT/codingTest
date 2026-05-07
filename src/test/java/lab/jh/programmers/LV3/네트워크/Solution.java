package lab.jh.programmers.LV3.네트워크;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer1 = 2;
        int result1 = new Solution().solution(n1, computers1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 3;
        int[][] computers2 = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int answer2 = 1;
        int result2 = new Solution().solution(n2, computers2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(int n, int[][] computers) {
        return bfs(computers, n);
    }

    private int bfs(int[][] computers, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            count++;
            queue.offer(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if (visited[cur]) {
                    continue;
                }

                visited[cur] = true;

                for (int j = 0; j < n; j++) {
                    if (cur == j || visited[j]) {
                        continue;
                    }

                    if (computers[cur][j] == 1) {
                        queue.offer(j);
                    }
                }
            }
        }

        return count;
    }
}