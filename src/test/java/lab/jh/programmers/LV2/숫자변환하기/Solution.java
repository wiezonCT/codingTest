package lab.jh.programmers.LV2.숫자변환하기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 40;
        int n1 = 5;
        int answer1 = 2;
        int result1 = new Solution().solution(x1, y1, n1);
        PRINT_RESULT(1, result1, answer1);

        int x2 = 10;
        int y2 = 40;
        int n2 = 30;
        int answer2 = 1;
        int result2 = new Solution().solution(x2, y2, n2);
        PRINT_RESULT(2, result2, answer2);

        int x3 = 2;
        int y3 = 5;
        int n3 = 4;
        int answer3 = -1;
        int result3 = new Solution().solution(x3, y3, n3);
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
        return bfs(x, y, n);
    }

    private int bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        queue.add(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] > y || visited[cur[0]]) {
                continue;
            }

            visited[cur[0]] = true;

            if (cur[0] == y) {
                return cur[1];
            }

            queue.add(new int[]{cur[0] * 3, cur[1] + 1});
            queue.add(new int[]{cur[0] * 2, cur[1] + 1});
            queue.add(new int[]{cur[0] + n, cur[1] + 1});
        }

        return -1;
    }
}