package lab.wy.programmers.guhyeon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Lv 2 (프로그래머스)
 *
 *  문제) 갈색이 노란색을 감싸고 있는 직사각형 형태
 *
 * 제한사항
 * 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
 * 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
 * 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 *
 */
public class carpet {

    @Test
    void test(){
        Assertions.assertArrayEquals( new int[]{4, 3},solution(10,2));
        Assertions.assertArrayEquals(new int[] {3,3}, solution(8,1));
        Assertions.assertArrayEquals(new int[] {8,6} ,solution(24,24));

        Assertions.assertArrayEquals( new int[]{4, 3},bestPractice(10,2));
        Assertions.assertArrayEquals(new int[] {3,3}, bestPractice(8,1));
        Assertions.assertArrayEquals(new int[] {8,6} ,bestPractice(24,24));
    }

    private int[] solution(int brown, int yellow){
        int maxHeight = 5000/4; // 갈색개수가 5000이하이고, 가로길이가 더 길어야하므로, 최대 높이는 5000/4
        int maxWidth = 5000/4; // 동일 구조

        for(int height = 3; height < maxHeight; height++){
            for(int width = 3; width < maxWidth; width++){
                if( (brown == ((height -2) *2 + (width) * 2))
                && (yellow == ((height -2) * (width - 2)))){
                    return new int[] {width, height};
                }
            }
        }

        return new int[] {};
    }


    private int[] bestPractice(int brown, int yellow) {

        int total = brown + yellow;

        // height 크기가 width total 중간값보다 크면 중복되므로 제거
        // math.sqrt(total) 이 필요
        for (int height = 3; height <= Math.sqrt(total); height++) {

            // 약수 비교
            if (total % height == 0) {

                int width = total / height;

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }
}
