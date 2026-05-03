package lab.jh.programmers.LV2.큰수만들기;

import javax.swing.text.Style;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String number1 = "1924";
        int k1 = 2;
        String answer1 = "94";
        String result1 = new Solution().solution(number1, k1);
        PRINT_RESULT(1, result1, answer1);

        String number2 = "1231234";
        int k2 = 3;
        String answer2 = "3234";
        String result2 = new Solution().solution(number2, k2);
        PRINT_RESULT(2, result2, answer2);

        String number3 = "4177252841";
        int k3 = 4;
        String answer3 = "775841";
        String result3 = new Solution().solution(number3, k3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        stack.push(number.charAt(0));

        int count = 0;
        for (int i = 1; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < number.charAt(i) && count < k) {
                stack.pop();
                count++;
            }

            stack.push(number.charAt(i));
        }

        while (!stack.isEmpty() && count < k) {
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}