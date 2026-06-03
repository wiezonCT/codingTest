package lab.wy.programmers.탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 무인도여행 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{1, 1, 27}, solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}));
        Assertions.assertArrayEquals(new int[]{-1}, solution(new String[]{"XXX", "XXX", "XXX"}));
    }

    /*
    X 5 9 1 X
    X 1 X 5 X
    X 2 3 1 X
    1 X X X 1
     */

    private int[] solution(String[] maps) {

        List<Integer> resultList = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        Character[][] map = new Character[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            int colCount = maps[i].length();
            for (int j = 0; j < colCount; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }


        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                int resultCount = bfs(i, j, map, visited);
                if (resultCount > 0) {
                    resultList.add(resultCount);
                }
            }
        }

        if (resultList.isEmpty()) {
            return new int[]{-1};
        }


        return resultList.stream().sorted().mapToInt(i -> i).toArray();
    }


    private int bfs(int currentRow, int currentCol, Character[][] map, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{currentRow, currentCol});

        int maxRow = map.length;
        int minRow = -1;
        int maxCol = map[0].length;
        int minCol = -1;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];

            Character target = map[row][col];
            if (visited[row][col] || target == 'X') {
                continue;
            } else {
                visited[row][col] = true;
            }

            // 상
            if (row - 1 > minRow && map[row - 1][col] != 'X' && !visited[row - 1][col]) {
                queue.offer(new int[]{row - 1, col});
            }

            // 좌
            if (col - 1 > minCol && map[row][col - 1] != 'X' && !visited[row][col - 1]) {
                queue.offer(new int[]{row, col - 1});
            }

            // 하
            if (row + 1 < maxRow && map[row + 1][col] != 'X' && !visited[row + 1][col]) {
                queue.offer(new int[]{row + 1, col});
            }

            // 우
            if (col + 1 < maxCol && map[row][col + 1] != 'X' && !visited[row][col + 1]) {
                queue.offer(new int[]{row, col + 1});
            }

            count = count + Integer.parseInt(target.toString());
        }
        return count;
    }
}
