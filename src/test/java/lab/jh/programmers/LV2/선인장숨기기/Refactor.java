package lab.jh.programmers.LV2.선인장숨기기;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Refactor {
    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        int h1 = 2;
        int w1 = 2;
        int[][] drops1 = new int[][]{{0, 0}, {3, 1}, {1, 3}, {2, 4}, {1, 1}, {2, 2}, {2, 3}, {0, 4}};
        int[] answer1 = new int[]{2, 2};
        int[] result1 = new Refactor().solution(m1, n1, h1, w1, drops1);
        PRINT_RESULT(1, result1, answer1);

        int m2 = 3;
        int n2 = 3;
        int h2 = 1;
        int w2 = 1;
        int[][] drops2 = new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}};
        int[] answer2 = new int[]{1, 1};
        int[] result2 = new Refactor().solution(m2, n2, h2, w2, drops2);
        PRINT_RESULT(2, result2, answer2);

        int m3 = 4;
        int n3 = 6;
        int h3 = 3;
        int w3 = 4;
        int[][] drops3 = new int[][]{{1, 2}};
        int[] answer3 = new int[]{0, 0};
        int[] result3 = new Refactor().solution(m3, n3, h3, w3, drops3);
        PRINT_RESULT(3, result3, answer3);

        int m4 = 4;
        int n4 = 6;
        int h4 = 1;
        int w4 = 2;
        int[][] drops4 = new int[][]{{0, 1}, {0, 3}, {0, 5}, {1, 1}, {1, 3}, {1, 5}, {2, 1}, {2, 3}, {2, 5}, {3, 1}, {3, 3}, {3, 5}};
        int[] answer4 = new int[]{3, 4};
        int[] result4 = new Refactor().solution(m4, n4, h4, w4, drops4);
        PRINT_RESULT(4, result4, answer4);

        int m5 = 2;
        int n5 = 2;
        int h5 = 2;
        int w5 = 2;
        int[][] drops5 = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}};
        int[] answer5 = new int[]{0, 0};
        int[] result5 = new Refactor().solution(m5, n5, h5, w5, drops5);
        PRINT_RESULT(5, result5, answer5);

        int m6 = 4;
        int n6 = 4;
        int h6 = 3;
        int w6 = 1;
        int[][] drops6 = new int[][]{{2, 0}, {1, 3}, {3, 2}, {0, 1}};
        int[] answer6 = new int[]{0, 2};
        int[] result6 = new Refactor().solution(m6, n6, h6, w6, drops6);
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

        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }

        int time = 1;
        for (int[] drop : drops) {
            map[drop[0]][drop[1]] = time++;
        }

        return map;
    }

    private int[] latelyRain(int[][] map, int h, int w) {
        int[][] rowMin = new int[m][n - w + 1];
        for (int i = 0; i < m; i++) {
            rowMin[i] = getSlidingWindowMin(map[i], w);
        }

        int maxTime = -1;
        int maxY = 0, maxX = 0;

        for (int j = 0; j < n - w + 1; j++) {
            int[] col = new int[m];
            for (int i = 0; i < m; i++) {
                col[i] = rowMin[i][j];
            }

            int[] colMin = getSlidingWindowMin(col, h);

            for (int i = 0; i < m - h + 1; i++) {
                if (colMin[i] > maxTime) {
                    maxTime = colMin[i];
                    maxY = i;
                    maxX = j;
                } else if (colMin[i] == maxTime) {
                    if (maxY > i || (maxY == i && maxX > j)) {
                        maxY = i;
                        maxX = j;
                    }
                }
            }
        }

        return new int[]{maxY, maxX};
    }

    private int[] getSlidingWindowMin(int[] arr, int k) {
        int len = arr.length;
        int[] res = new int[len - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        // 1. 구간의 최솟값의 인덱스로 모두 채운다.
        for (int i = 0; i < len; i++) {
            // 2. 첫 번째 인덱스가 범위에서 벗어났으면 비워버리기.
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 3. 마지막 인덱스가 새로 삽입할 값 이상이라면 없애버리기
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                deque.pollLast();
            }

            // 4. 맨 뒤에 삽입되는 것은 가장 큰 값
            deque.offerLast(i);

            if (i >= k - 1) {
                // 5. 결과 배열에 해당 구간의 최솟값 넣기
                res[i - k + 1] = arr[deque.peek()];
            }
        }

        return res;
    }
}