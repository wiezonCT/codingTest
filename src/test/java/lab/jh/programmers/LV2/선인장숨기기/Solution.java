package lab.jh.programmers.LV2.선인장숨기기;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        int h1 = 2;
        int w1 = 2;
        int[][] drops1 = new int[][]{{0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}};
        int[] answer1 = new int[]{2, 2};
        int[] result1 = new Solution().solution(m1, n1, h1, w1, drops1);
        PRINT_RESULT(1, result1, answer1);

        int m2 = 3;
        int n2 = 3;
        int h2 = 1;
        int w2 = 1;
        int[][] drops2 = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}};
        int[] answer2 = new int[]{1, 1};
        int[] result2 = new Solution().solution(m2, n2, h2, w2, drops2);
        PRINT_RESULT(2, result2, answer2);

        int m3 = 4;
        int n3 = 6;
        int h3 = 3;
        int w3 = 4;
        int[][] drops3 = new int[][]{{1, 2}};
        int[] answer3 = new int[]{0, 0};
        int[] result3 = new Solution().solution(m3, n3, h3, w3, drops3);
        PRINT_RESULT(3, result3, answer3);

        int m4 = 4;
        int n4 = 6;
        int h4 = 1;
        int w4 = 2;
        int[][] drops4 = new int[][]{{0, 1}, {0, 3}, {0, 5}, {1, 1}, {1, 3}, {1, 5}, {2, 1}, {2, 3}, {2, 5}, {3, 1}, {3, 3}, {3, 5}};
        int[] answer4 = new int[]{3, 4};
        int[] result4 = new Solution().solution(m4, n4, h4, w4, drops4);
        PRINT_RESULT(4, result4, answer4);

        int m5 = 2;
        int n5 = 2;
        int h5 = 2;
        int w5 = 2;
        int[][] drops5 = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        int[] answer5 = new int[]{0, 0};
        int[] result5 = new Solution().solution(m5, n5, h5, w5, drops5);
        PRINT_RESULT(5, result5, answer5);

        int m6 = 4;
        int n6 = 4;
        int h6 = 3;
        int w6 = 1;
        int[][] drops6 = new int[][]{{2, 0}, {1, 3}, {3, 2}, {0, 1}};
        int[] answer6 = new int[]{0, 2};
        int[] result6 = new Solution().solution(m6, n6, h6, w6, drops6);
        PRINT_RESULT(6, result6, answer6);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] map = initialMap(drops, m, n);
        return latelyRain(map, h, w);
    }

    int m, n;
    private int[][] initialMap(int[][] drops, int m, int n) {
        int[][] map = new int[m][n];
        this.m = m;
        this.n = n;

        int time = 1;
        for (int[] drop : drops) {
            map[drop[0]][drop[1]] = time++;
        }

        return map;
    }

    private int[] latelyRain(int[][] map, int h, int w) {
        int maxTime = Integer.MIN_VALUE;
        int maxY = -1, maxX = -1;

        for (int i = 0; i < m; i++) {
            if (maxTime == Integer.MAX_VALUE) {
                break;
            }

            for (int j = 0; j < n; j++) {
                if (maxTime == Integer.MAX_VALUE) {
                    break;
                }

                int searchTime = searchZone(map, i, j, h, w);

                if (searchTime == -1) {
                    continue;
                }

                if (searchTime > maxTime) {
                    maxTime = searchTime;
                    maxY = i;
                    maxX = j;
                }
            }
        }

        return new int[]{maxY, maxX};
    }

    private int searchZone(int[][] map, int y, int x, int h, int w) {
        int time = -1;

        if (y + h > m || x + w > n) {
            return time;
        }
        time = Integer.MAX_VALUE;

        for (int i = y; i < y + h; i++) {
            for (int j = x; j < x + w; j++) {
                if (map[i][j] != 0) {
                    time = Math.min(time, map[i][j]);
                }
            }
        }

        return time;
    }
}