package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 프로세스 {

    @Test
    void test() {
        Assertions.assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
        Assertions.assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }


    private int solution(int[] priorties, int location) {

        class Process {
            Integer priority;
            boolean isTarget;

            public Process(Integer priority, boolean isTarget) {
                this.priority = priority;
                this.isTarget = isTarget;
            }

            public Integer getPriority() {
                return priority;
            }

            public Boolean getIsTarget() {
                return isTarget;
            }


        }

        // step1 ) 초기 큐 셋팅
        Deque<Process> processQueue = new ArrayDeque<>();
        for (int i = 0; i < priorties.length; i++) {
            processQueue.add(new Process(priorties[i], location == i));
        }

        // step2 ) 프로세스 실행
        int count = 0; // 실행 순서
        while (!processQueue.isEmpty()) {

            Process current = processQueue.poll();
            Boolean hasHigherPriority = false;

            // 값 비교 ( 큐에서 높은 우선순위 있는지 확인 )
            for (Process p : processQueue) {
                if (p.getPriority() > current.getPriority()) {
                    hasHigherPriority = true;
                    break;
                }
            }

            // 우선순위가 더 높은게 존재하면 뒤로 이동
            if (hasHigherPriority) {
                processQueue.add(current);
            } else {

                // 아니면, pop 그대로 하고  값 증가
                count++;

                // target 이면, count 리턴
                if (current.getIsTarget()) {
                    return count;
                }
            }
        }

        return count;
    }
}
