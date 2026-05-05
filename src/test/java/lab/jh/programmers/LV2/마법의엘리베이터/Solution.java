package lab.jh.programmers.LV2.마법의엘리베이터;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int storey1 = 16;
        int answer1 = 6;
        int result1 = new Solution().solution(storey1);
        PRINT_RESULT(1, result1, answer1);

        int storey2 = 2554;
        int answer2 = 16;
        int result2 = new Solution().solution(storey2);
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

    public int solution(int storey) {
        int count = 0;

        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;

            if (digit > 5) {
                count += (10 - digit);
                storey++;
            } else if (digit < 5) {
                count += digit;
            } else {
                count += digit;
                if (storey % 10 >= 5) {
                    storey++;
                }
            }
        }

        return count;
    }
}