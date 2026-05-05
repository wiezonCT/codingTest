package lab.jh.programmers.LV2.쿼드압축후개수세기;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] answer1 = new int[]{4, 9};
        int[] result1 = new Solution().solution(arr1);
        PRINT_RESULT(1, result1, answer1);

        int[][] arr2 = new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
        int[] answer2 = new int[]{10, 15};
        int[] result2 = new Solution().solution(arr2);
        PRINT_RESULT(2, result2, answer2);
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

    public int[] solution(int[][] arr) {
        count = new int[2];
        divide(arr, 0, 0, arr.length);
        return count;
    }

    static int[] count;
    private void divide(int[][] arr, int y, int x, int size) {
        if (isPossibleZip(arr, y, x, size)) {
            count[arr[y][x]]++;
            return;
        }

        int divideSize = size / 2;
        divide(arr, y, x, divideSize);
        divide(arr, y, x + divideSize, divideSize);
        divide(arr, y + divideSize, x, divideSize);
        divide(arr, y + divideSize, x + divideSize, divideSize);
    }

    private boolean isPossibleZip(int[][] arr, int y, int x, int size) {
        int temp = arr[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != temp) {
                    return false;
                }
            }
        }

        return true;
    }
}