package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{2}, solution(new int[]{95, 99}, new int[]{1, 1}));
        Assertions.assertArrayEquals(new int[]{2, 1}, solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));

        Assertions.assertArrayEquals(new int[]{2}, bestPractice(new int[]{95, 99}, new int[]{1, 1}));
        Assertions.assertArrayEquals(new int[]{2, 1}, bestPractice(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, bestPractice(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }

    private int[] solution(int[] progresses, int[] speeds) {
        boolean[] isCompleted = new boolean[progresses.length];
        List<Integer> deploy = new ArrayList<>();

        while (true) {
            int deployCount = 0;
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];

                // 첫값이 100일경우,
                if (i == 0 && progresses[i] >= 100 && isCompleted[i] == false) {
                    isCompleted[i] = true;
                    deployCount++;
                }
                if (i != 0 && progresses[i] >= 100 && isCompleted[i - 1] == true && isCompleted[i] == false) {
                    isCompleted[i] = true;
                    deployCount++;
                }
            }
            if (deployCount != 0) {
                deploy.add(deployCount);
            }

            int resultSize = 0;
            for (int number : deploy) {
                resultSize += number;
            }

            if (resultSize == progresses.length) {
                break;
            }
        }

        return deploy.stream().mapToInt(i -> i).toArray();
    }

    //Queue 풀이
    public int[] bestPractice(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> deploy = new ArrayList<>();

        // 1. 각 작업이 끝나는데 필요한 일수를 계산하여 Queue에 순서대로 삽입
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        // 2. Queue가 빌 때까지 배포 그룹핑 진행
        while (!queue.isEmpty()) {
            // 기준이 되는 맨 앞 기능의 완료일 꺼내기
            int currentDay = queue.poll();
            int deployCount = 1;

            // 3. 다음 대기열(peek)의 완료일이 기준일보다 작거나 같으면 함께 배포(poll)
            while (!queue.isEmpty() && queue.peek() <= currentDay) {
                queue.poll();
                deployCount++;
            }

            deploy.add(deployCount);
        }

        return deploy.stream().mapToInt(i -> i).toArray();
    }
}
