package lab.jh.programmers.LV2.리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] board1 = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer1 = 7;
        int result1 = new Solution().solution(board1);
        PRINT_RESULT(1, result1, answer1);

        String[] board2 = new String[]{".D.R", "....", ".G..", "...D"};
        int answer2 = -1;
        int result2 = new Solution().solution(board2);
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

    public int solution(String[] board) {
        Position start = findStartPosition(board);
        return bfs(board, start);
    }

    private Position findStartPosition(String[] board) {
        int len = board.length;
        int len2 = board[0].length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                if (board[i].charAt(j) == 'R') {
                    return new Position(i, j, 0);
                }
            }
        }

        return null;
    }

    private int bfs(String[] board, Position start) {
        Queue<Position> q = new LinkedList<>();
        int len = board.length;
        int len2 = board[0].length();
        boolean[][] visited = new boolean[len][len2];
        q.offer(start);

        while (!q.isEmpty()) {
            Position p = q.poll();

            if (board[p.y].charAt(p.x) == 'G') {
                return p.cost;
            }

            if (visited[p.y][p.x]) {
                continue;
            }

            visited[p.y][p.x] = true;

            for (int i = 0; i < 4; i++) {
                q.offer(move(board, i, p));
            }
        }

        return -1;
    }

    /**
     *
     * @param direction 0: 상, 1: 하, 2: 좌, 3: 우
     */
    static int[] d = {1, -1, 0, 0};
    private Position move(String[] board, int direction, Position start) {
        int len = board.length;
        int len2 = board[0].length();

        int dy = d[direction];
        int dx = d[3 - direction];

        int ny = start.y + dy;
        int nx = start.x + dx;

        while (ny < len && ny >= 0 && nx < len2 && nx >= 0 && board[ny].charAt(nx) != 'D') {
            ny += dy;
            nx += dx;
        }

        return new Position(ny - dy, nx - dx, start.cost + 1);
    }

    static class Position {
        int y, x, cost;

        public Position(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }
}