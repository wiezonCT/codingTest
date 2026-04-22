package lab.jh.programmers.LV1.가장많이받은선물;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] friends1 = new String[]{"muzi", "ryan", "frodo", "neo"};
        String[] gifts1 = new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        int answer1 = 2;
        int result1 = new Solution().solution(friends1, gifts1);
        PRINT_RESULT(1, result1, answer1);

        String[] friends2 = new String[]{"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts2 = new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        int answer2 = 4;
        int result2 = new Solution().solution(friends2, gifts2);
        PRINT_RESULT(2, result2, answer2);

        String[] friends3 = new String[]{"a", "b", "c"};
        String[] gifts3 = new String[]{"a b", "b a", "c a", "a c", "a c", "c a"};
        int answer3 = 0;
        int result3 = new Solution().solution(friends3, gifts3);
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

    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        init(map, friends, gifts);

        return calculateReceiveGifts(map, friends);
    }

    private void init(Map<String, Map<String, Integer>> map, String[] friends, String[] gifts) {
        for (String friend : friends) {
            Map<String, Integer> friendMap = new HashMap<>();
            for (String friend2 : friends) {
                if (friend2.equals(friend)) {
                    continue;
                }
                friendMap.put(friend2, 0);
            }
            friendMap.put("power", 0);
            map.put(friend, friendMap);
        }

        for (String gift : gifts) {
            String[] giftArray = gift.split(" ");
            Map<String, Integer> giftMap = map.get(giftArray[0]);
            Map<String, Integer> receiveMap = map.get(giftArray[1]);

            giftMap.put("power", giftMap.get("power") + 1);
            giftMap.put(giftArray[1], giftMap.get(giftArray[1]) + 1);

            receiveMap.put("power", receiveMap.get("power") - 1);
        }
    }

    private int calculateReceiveGifts(Map<String, Map<String, Integer>> map, String[] friends) {
        int maxCount = 0;
        for (int i = 0; i < friends.length; i++) {
            int count = 0;
            String friend = friends[i];
            for (int j = 0; j < friends.length; j++) {
                String friend2 = friends[j];
                if (i == j) {
                    continue;
                }

                int giveCount = map.get(friend).get(friend2);
                int receiveCount = map.get(friend2).get(friend);

                if (giveCount < receiveCount) {
                    continue;
                }

                if (giveCount == receiveCount) {
                    int givePower = map.get(friend).get("power");
                    int receivePower = map.get(friend2).get("power");

                    if (givePower <= receivePower) {
                        continue;
                    }
                }

                count++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}