package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 의상 {
    @Test
    void test(){
        //[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
        Assertions.assertEquals(5, solution(new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));
    }

    private int solution(String[][] clothes){
        Map<String, List<String>> clothMap =new HashMap<>();
        for(int row = 0; row < clothes.length; row++){
            clothMap.putIfAbsent(clothes[row][1], new ArrayList<>());
            clothMap.get(clothes[row][1]).add(clothes[row][0]);
        }

        int sum = 1;
        for(Map.Entry<String, List<String>> entry : clothMap.entrySet()){
            sum *= clothMap.get(entry.getKey()).size() + 1;
        }

        return sum -1;
    }
}
