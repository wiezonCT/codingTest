package lab.jh.programmers.LV2.프로세스;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[] priorities1 = new int[]{2, 1, 3, 2};
        int location1 = 2;
        int answer1 = 1;
        int result1 = new Solution().solution(priorities1, location1);
        PRINT_RESULT(1, result1, answer1);

        int[] priorities2 = new int[]{1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int answer2 = 5;
        int result2 = new Solution().solution(priorities2, location2);
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

    public int solution(int[] priorities, int location) {
        PriorityQueue<Process> pq = new PriorityQueue<>();
        Queue<Process> q = new LinkedList<>();

        init(pq, q, priorities);

        return findLocation(pq, q, location);
    }

    private void init(PriorityQueue<Process> pq, Queue<Process> q, int[] priorities) {
        for (int i = 0; i < priorities.length; i++) {
            pq.add(new Process(i, priorities[i]));
            q.add(new Process(i, priorities[i]));
        }
    }

    private int findLocation(PriorityQueue<Process> pq, Queue<Process> q, int location) {
        int count = 0;

        while (!q.isEmpty()) {
            Process p = q.poll();

            if (p.priority < pq.peek().priority) {
                q.offer(p);
                continue;
            }

            pq.poll();
            count++;

            if (p.index == location) {
                return count;
            }
        }

        return -1;
    }

    static class Process implements Comparable<Process> {
        int index;
        int priority;

        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        private void print() {
            System.out.printf("%d %d\n", index, priority);
        }

        @Override
        public int compareTo(Process o) {
            return o.priority - this.priority;
        }
    }
}