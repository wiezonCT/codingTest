package lab.wy.programmers.탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {

    /**
     * 1. 최단거리 구하기
     * 2. 0(벽) , 1(길)
     * 3. map 제공 , 시작위치 (0,0) 고정
     * 4. target -> (n,m) 끝에 위치 존재
     * (예외 : 도착하지 못하는 경우 -1 값 고정)
     */

    @Test
    void test() {
        Assertions.assertEquals(11, solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
        Assertions.assertEquals(-1, solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}));
    }


    private int solution(int[][] map) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[][] visited = new int[map.length][map[0].length];
        int maxRow = map.length;
        int minRow = -1;
        int maxCol = map[0].length;
        int minCol = -1;

        int startCol = 0;
        int startRow = 0;
        queue.offer(startCol);
        queue.offer(startRow);
        visited[startRow][startCol] = 1;

        while (!queue.isEmpty()) {
            Integer column = queue.poll();
            Integer row = queue.poll();

            // 위
            if (row - 1 > minRow && map[row - 1][column] != 0) {
                if (visited[row - 1][column] == 0) {
                    queue.offer(column);
                    queue.offer(row - 1);
                    visited[row - 1][column] = visited[row][column] + 1;
                }
            }

            // 아래
            if (row + 1 < maxRow && map[row + 1][column] != 0) {
                if (visited[row + 1][column] == 0) {
                    queue.offer(column);
                    queue.offer(row + 1);
                    visited[row + 1][column] = visited[row][column] + 1;
                }
            }

            // 오른쪽
            if (column + 1 < maxCol && map[row][column + 1] != 0) {
                if (visited[row][column + 1] == 0) {
                    queue.offer(column + 1);
                    queue.offer(row);
                    visited[row][column + 1] = visited[row][column] + 1;
                }
            }

            // 왼쪽
            if (column - 1 > minCol && map[row][column - 1] != 0) {
                if (visited[row][column - 1] == 0) {
                    queue.offer(column - 1);
                    queue.offer(row);
                    visited[row][column - 1] = visited[row][column] + 1;
                }
            }
        }


        return visited[map.length - 1][map[0].length - 1] == 0 ? -1 : visited[map.length - 1][map[0].length - 1];
    }


}
