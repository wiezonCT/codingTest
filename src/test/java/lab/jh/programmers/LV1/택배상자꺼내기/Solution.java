package lab.jh.programmers.LV1.택배상자꺼내기;

import java.util.Arrays;

/**
 * Problem: 택배상자꺼내기
 * Level: 1
 *
 * @author 이종현
 * @date 2026-04-19
 * @category ?
 * @description 
 */
class Solution {
    public static void main(String[] args) {
        int n1 = 22;
        int w1 = 6;
        int num1 = 8;
        int answer1 = 3;
        int result1 = new Solution().solution(n1, w1, num1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 13;
        int w2 = 3;
        int num2 = 6;
        int answer2 = 4;
        int result2 = new Solution().solution(n2, w2, num2);
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

    public int solution(int n, int w, int num) {
        int height = (n - 1) / w + 1;
        int[][] boxes = makeBoxes(height, w);

        return findBoxes(boxes, num, n);
    }

    private int[][] makeBoxes(int height, int width) {
        int[][] boxes = new int[height][width];

        // true는 왼 -> 오 , false = 오 -> 왼
        boolean isLeftStart = false;
        int idx = 1;
        for (int i = 0; i < height; i++) {
            isLeftStart = !isLeftStart;
            if (isLeftStart) {
                for (int j = 0; j < width; j++) {
                    boxes[i][j] = idx++;
                }
                continue;
            }

            for (int j = width - 1; j >= 0; j--) {
                boxes[i][j] = idx++;
            }
        }

        return boxes;
    }

    private int findBoxes(int[][] boxes, int num, int n) {
        int y = -1, x = -1;
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                if (boxes[i][j] == num) {
                    y = i;
                    x = j;
                    break;
                }
            }

            if (x != -1) break;
        }

        int boxesSum = 0;
        for (int i = y; i < boxes.length; i++) {
            if (boxes[i][x] <= n) boxesSum++;
        }

        return boxesSum;
    }
}