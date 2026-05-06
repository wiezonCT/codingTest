package lab.wy.programmers.탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class 타겟넘버 {

    @Test
    void test() {
        Assertions.assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
        Assertions.assertEquals(2, solution(new int[]{4, 1, 2, 1}, 4));
    }

    private int count = 0;

    private int solution(int[] numbers, int target) {

        count = 0;
        dfs(numbers, target, 0, 0);

        return count;
    }


    private void dfs(int[] numbers, int target, int index, int sum) {

        // 끝내는 조건문
        if (index == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // + 연산 수행 ( 맨앞 부터 순서대로 )
        dfs(numbers, target, index + 1, sum + numbers[index]);
        // - 연산 수행 ( 맨뒤 부터 순서대로 )
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
