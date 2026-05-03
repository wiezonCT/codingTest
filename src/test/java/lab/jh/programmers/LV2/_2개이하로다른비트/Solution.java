package lab.jh.programmers.LV2._2개이하로다른비트;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        long[] numbers1 = new long[]{2L, 7L};
        long[] answer1 = new long[]{3L, 11L};
        long[] result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, long[] result, long[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;

        for (long number : numbers) {
            answer[idx++] = findSimilarBit(number);
        }

        return answer;
    }

    private long findSimilarBit(long n) {
        if (n % 2 == 0) {
            return n + 1;
        }

        String bits = Long.toBinaryString(n);
        if (bits.contains("0")) {
            int idx = bits.lastIndexOf("0");

            bits = bits.substring(0, idx) + "10" + bits.substring(idx + 2);
        } else {
            bits = "10" + bits.substring(1);
        }

        return Long.parseLong(bits, 2);
    }
}