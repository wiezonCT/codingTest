package lab.wy.programmers.guhyeon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// 구현 문제
// 최소 직사각형
public class smallest_rectangle {


    public int[][] card = {{60,50}, {30,70}, {60,30}, {80,40}};

    // 2차원 배열 존재
    // 왼쪽 , 오른쪽 swap (왼쪽 기준 작은값)
    // left, right 의 최대값 구하기
    @Test
    void test(){
        int leftMax = 0;
        int rightMax = 0;

        for (int i = 0; i < card.length; i++) {
            if ( card[i][0] > card[i][1]) {
                int temp = card[i][0];
                card[i][0] = card[i][1];
                card[i][1] = temp;
            }

            leftMax = Math.max(leftMax, card[i][0]);
            rightMax = Math.max(rightMax, card[i][1]);
        }

        Assertions.assertEquals(4000,leftMax * rightMax);

    }

    @Test
    void bestPractice(){
        int maxH = 0;
        int maxW = 0;

        for(int i = 0; i < card.length; i++){
            int w = Math.min(card[i][0], card[i][1]);
            int h = Math.max(card[i][0], card[i][1]);

            maxH = Math.max(maxH, h);
            maxW = Math.max(maxW, w);
        }

        Assertions.assertEquals(4000,maxH * maxW);
    }
}
