package lab.wy.programmers.구현;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Samchongsa {

    @Test
    void test(){
        Assertions.assertEquals(2, solution(new int[]{-2,3,0,2,-5}));
        Assertions.assertEquals(5, solution(new int[]{-3,-2,-1,0,1,2,3}));
        Assertions.assertEquals(0, solution(new int[]{-1,1,-1,1}));

        Assertions.assertEquals(2, dfsSolution(new int[]{-2,3,0,2,-5}));
        Assertions.assertEquals(5, dfsSolution(new int[]{-3,-2,-1,0,1,2,3}));
        Assertions.assertEquals(0, dfsSolution(new int[]{-1,1,-1,1}));
    }

    private int solution(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i +1; j < arr.length; j++){
                for(int k = j +1; k < arr.length; k++){
                    if( arr[i] + arr[j] + arr[k] == 0 )  count++;
                }
            }
        }
        return count;
    }



    private int count;
    private int dfsSolution(int[] arr){
        count = 0;
        dfs(arr,0,0, 0);
        return count;
    }


    private void dfs(int[] arr, int start, int depth, int sum){
        // 조합 끝
        if(depth == 3){
            // 조건
            if(sum == 0)
                count++;
            return;
        }

        // 조합 매칭 (3개 매칭 , 오른쪽으로 순차적으로 매칭)
        for(int i = start; i < arr.length; i++){
            dfs(arr, i+1, depth+1,  sum + arr[i]);
        }
    }

}
