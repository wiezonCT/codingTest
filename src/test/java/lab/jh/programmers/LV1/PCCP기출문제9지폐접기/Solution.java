package lab.jh.programmers.LV1.PCCP기출문제9지폐접기;

public class Solution {
    public static void main(String[] args) {
        int[] wallet1 = {30, 15};
        int[] bill1 = {26, 17};

        String answer1 = "1";
        String result1 = new lab.jh.programmers.LV1.PCCP기출문제9지폐접기.Solution().solution(wallet1, bill1) + "";
        PRINT_RESULT(1, result1, answer1);

        int[] wallet2 = {50, 50};
        int[] bill2 = {100, 241};

        String answer2 = "4";
        String result2 = new lab.jh.programmers.LV1.PCCP기출문제9지폐접기.Solution().solution(wallet2, bill2) + "";
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (!isAvailablePut(wallet, bill)) {
            answer++;
            divideBill(bill);
        }

        return answer;
    }

    private void divideBill(int[] bill) {
        if (bill[0] > bill[1]) {
            bill[0] /= 2;
            return;
        }

        bill[1] /= 2;
    }

    private boolean isAvailablePut(int[] wallet, int[] bill) {
        return (wallet[0] >= bill[0] && wallet[1] >= bill[1]) || (wallet[0] >= bill[1] && wallet[1] >= bill[0]);
    }
}
