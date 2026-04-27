package lab.jh.programmers.LV2.더맵게;

import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] scoville1 = new int[]{1, 2, 3, 9, 10, 12};
        int K1 = 7;
        int answer1 = 2;
        int result1 = new Solution().solution(scoville1, K1);
        PRINT_RESULT(1, result1, answer1);
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

    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        init(pq, scoville);
        return mixedCount(pq, K);
    }

    private void init(PriorityQueue<Long> pq, int[] scoville) {
        for (int scoville1 : scoville) {
            pq.add((long) scoville1);
        }
    }

    private int mixedCount(PriorityQueue<Long> pq, int K) {
        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            count++;
            long scoville1 = pq.poll();
            if (pq.isEmpty()) {
                return -1;
            }
            long scoville2 = pq.poll();

            pq.add(scoville1 + (2 * scoville2));
        }

        return count;
    }
}