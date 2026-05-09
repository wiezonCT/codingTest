package lab.jh.programmers.LV2.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer1 = 3;
        int result1 = new Solution().solution(n1, wires1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 4;
        int[][] wires2 = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int answer2 = 0;
        int result2 = new Solution().solution(n2, wires2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 7;
        int[][] wires3 = new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int answer3 = 1;
        int result3 = new Solution().solution(n3, wires3);
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

    public int solution(int n, int[][] wires) {
        List<Node> nodes = init(n, wires);
        return bruteForce(n, wires, nodes);
    }

    private List<Node> init(int n, int[][] wires) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new Node(i));
        }

        for (int[] wire : wires) {
            nodes.get(wire[0]).connect.add(wire[1]);
            nodes.get(wire[1]).connect.add(wire[0]);
        }

        return nodes;
    }

    private int bruteForce(int n, int[][] wires, List<Node> nodes) {
        int answer = n;

        for (int[] wire : wires) {
            nodes.get(wire[0]).connect.remove(Integer.valueOf(wire[1]));
            nodes.get(wire[1]).connect.remove(Integer.valueOf(wire[0]));

            int cnt = bfs(nodes, n);
            int diff = Math.abs(n - 2 * cnt);
            answer = Math.min(answer, diff);

            nodes.get(wire[0]).connect.add(wire[1]);
            nodes.get(wire[1]).connect.add(wire[0]);
        }

        return answer;
    }

    private int bfs(List<Node> nodes, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(nodes.get(1));
        visited[1] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;

            for (int next : node.connect) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(nodes.get(next));
                }
            }
        }

        return count;
    }

    static class Node {
        int idx;
        List<Integer> connect = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }
    }
}