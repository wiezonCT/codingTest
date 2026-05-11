package lab.jh.programmers.LV2.미로탈출;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] maps1 = new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int answer1 = 16;
        int result1 = new Solution().solution(maps1);
        PRINT_RESULT(1, result1, answer1);

        String[] maps2 = new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        int answer2 = -1;
        int result2 = new Solution().solution(maps2);
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

    public int solution(String[] maps) {
        int[][] map = init(maps);
        int lever = bfs(map, startY, startX, 2);
        int exit = bfs(map, leverY, leverX, 3);

        if (lever == -1 || exit == -1) {
            return -1;
        }

        return lever + exit;
    }

    // -1: 벽, 0: 시작, 1: 통로, 2: 레버, 3: 출구
    static int startY, startX, leverY, leverX, rows, cols;
    private int[][] init(String[] maps) {
        rows = maps.length;
        cols = maps[0].length();

        int[][] map = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = -2;
                temp = switch (maps[i].charAt(j)) {
                    case 'X' -> -1;
                    case 'S' -> 0;
                    case 'O' -> 1;
                    case 'L' -> 2;
                    case 'E' -> 3;
                    default -> temp;
                };

                map[i][j] = temp;

                if (temp == 0) {
                    startY = i;
                    startX = j;
                } else if (temp == 2) {
                    leverY = i;
                    leverX = j;
                }
            }
        }

        return map;
    }

    static int[] d = {-1, 1, 0, 0};
    private int bfs(int[][] map, int y, int x, int key) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Node q = queue.poll();
            if (map[q.y][q.x] == key) {
                return q.time;
            }

            for (int i = 0; i < 4; i++) {
                int dy = q.y + d[i];
                int dx = q.x + d[3 - i];

                if (dy >= rows || dy < 0 || dx >= cols || dx < 0 || visited[dy][dx] || map[dy][dx] == -1) continue;

                visited[dy][dx] = true;
                queue.offer(new Node(dy, dx, q.time + 1));
            }
        }

        return -1;
    }

    static class Node {
        int y, x, time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        private void print() {
            System.out.printf("%d %d %d\n", y, x, time);
        }
    }
}