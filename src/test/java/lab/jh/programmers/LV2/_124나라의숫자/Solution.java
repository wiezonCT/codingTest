package lab.jh.programmers.LV2._124나라의숫자;

class Solution {
    public static void main(String[] args) {
        int n1 = 1;
        String answer1 = "1";
        String result1 = new Solution().solution(n1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 2;
        String answer2 = "2";
        String result2 = new Solution().solution(n2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 3;
        String answer3 = "4";
        String result3 = new Solution().solution(n3);
        PRINT_RESULT(3, result3, answer3);

        int n4 = 4;
        String answer4 = "11";
        String result4 = new Solution().solution(n4);
        PRINT_RESULT(4, result4, answer4);
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

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] nums = {"4", "1", "2"};
        while (n > 0) {
            int num = n % 3;

            if (num == 0) {
                n--;
            }

            sb.append(nums[num]);

            n /= 3;
        }

        return sb.reverse().toString();
    }

}