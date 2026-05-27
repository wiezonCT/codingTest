package lab.wy.programmers.이분탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 예산 {
    @Test
    void test() {
        Assertions.assertEquals(3, solution(new int[]{1, 3, 2, 5, 4}, 9));
        Assertions.assertEquals(4, solution(new int[]{2, 2, 3, 3}, 10));
    }

    private int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int cost : d) {
            if (budget < cost) {
                break;
            }
            count++;
            budget -= cost;

        }
        return count;
    }
}
