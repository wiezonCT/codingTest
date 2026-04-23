package lab.jh.programmers.LV1.달리기경주;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] players1 = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings1 = new String[]{"kai", "kai", "mine", "mine"};
        String[] answer1 = new String[]{"mumu", "kai", "mine", "soe", "poe"};
        String[] result1 = new Solution().solution(players1, callings1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, String[] result, String[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> initialRank = new HashMap<>();
        Map<String, Integer> initialRankPlayer = new HashMap<>();

        init(initialRank, initialRankPlayer, players);
        pass(initialRank, initialRankPlayer, callings);

        String[] answer = new String[players.length];
        for (int i = 1; i <= players.length; i++) {
            answer[i - 1] = initialRank.get(i);
        }

        return answer;
    }

    private void init(Map<Integer, String> initialRank, Map<String, Integer> initialRankPlayer, String[] players) {
        for (int i = 1; i <= players.length; i++) {
            initialRank.put(i, players[i - 1]);
            initialRankPlayer.put(players[i - 1], i);
        }
    }

    private void pass(Map<Integer, String> initialRank, Map<String, Integer> initialRankPlayer, String[] callings) {
        for (String calling : callings) {
            int callingRank = initialRankPlayer.get(calling);

            String frontPlayer = initialRank.get(callingRank - 1);

            initialRank.put(callingRank - 1, calling);
            initialRank.put(callingRank, frontPlayer);

            initialRankPlayer.put(frontPlayer, callingRank);
            initialRankPlayer.put(calling, callingRank - 1);
        }
    }
}