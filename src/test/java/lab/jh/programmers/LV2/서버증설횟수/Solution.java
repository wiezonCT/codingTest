package lab.jh.programmers.LV2.서버증설횟수;

class Solution {
    public static void main(String[] args) {
        int[] players1 = new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m1 = 3;
        int k1 = 5;
        int answer1 = 7;
        int result1 = new Solution().solution(players1, m1, k1);
        PRINT_RESULT(1, result1, answer1);

        int[] players2 = new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
        int m2 = 5;
        int k2 = 1;
        int answer2 = 11;
        int result2 = new Solution().solution(players2, m2, k2);
        PRINT_RESULT(2, result2, answer2);

        int[] players3 = new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int m3 = 1;
        int k3 = 1;
        int answer3 = 12;
        int result3 = new Solution().solution(players3, m3, k3);
        PRINT_RESULT(3, result3, answer3);
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

    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int len = players.length;
        int currentServers = 0;
        int[] addServers = new int[len];

        for (int i = 0; i < len; i++) {
            int player = players[i];
            if (i - k >= 0) {
                currentServers -= addServers[i - k];
            }

            int addServer = howAddServers(currentServers, m, player);

            answer += addServer;

            addServers[i] = addServer;
            currentServers += addServer;
        }

        return answer;
    }

    private int howAddServers(int currentServers, int m, int n) {
        return currentServers >= n / m ? 0 : (n / m - currentServers);
    }
}