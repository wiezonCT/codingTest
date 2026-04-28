package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 주식가격 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, solution(new int[]{1, 2, 3, 2, 3}));
        Assertions.assertArrayEquals(new int[]{4, 3, 1, 1, 0}, bestSolution(new int[]{1, 2, 3, 2, 3}));
    }


    private int[] solution(int[] prices) {
        Deque<Integer> pricesQueue = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();


        for (int price : prices) {
            pricesQueue.offer(price);
        }

        while (!pricesQueue.isEmpty()) {
            int second = 0;

            if (pricesQueue.size() == 1) {
                pricesQueue.poll();
                resultList.add(second);
                break;
            }

            for (int i = prices.length - pricesQueue.size() + 1; i < prices.length; i++) {
                Integer comparePrice = pricesQueue.peek();


                second++;
                if (comparePrice > prices[i]) {
                    pricesQueue.poll();
                    resultList.add(second);
                    break;
                }

                if (i == prices.length - 1) {
                    pricesQueue.poll();
                    resultList.add(second);
                }
            }
        }


        return resultList.stream().mapToInt(i -> i).toArray();
    }


    private int[] bestSolution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }

            stack.push(i);
        }


        while (!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices.length - pop - 1;
        }

        return result;
    }
}
