package lab.wy.programmers.guhyeon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fail {

    @Test
    void test(){
        Assertions.assertArrayEquals(new int[] {3,4,2,1,5},solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
        Assertions.assertArrayEquals(new int[] {4,1,2,3},solution(4, new int[] {4,4,4,4,4}));

        Assertions.assertArrayEquals(new int[] {3,4,2,1,5},bestPractice(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}));
        Assertions.assertArrayEquals(new int[] {4,1,2,3},bestPractice(4, new int[] {4,4,4,4,4}));
    }



    private int[] solution(int N, int[] stages){

        // N+1 까지 들어올 수 있으므로
        int[] stageInfos = new int[N+2];
        for(int i = 0; i < stages.length; i++){
            stageInfos[stages[i]]++;
        }

        System.out.println(Arrays.toString(stageInfos));

        int[] sumStage = new int[N+2];
        for(int i = 1; i <= N+1; i++){
            for(int j = N+1; j >= i; j-- ){
                sumStage[i] += stageInfos[j];
            }
        }


        double[] result = new double[N+1];
        for(int i = 1; i <= N ; i++ ){
            if(sumStage[i] == 0){
                result[i] = 0;
            }else{
                result[i] = (double)stageInfos[i] / sumStage[i];
            }
        }

        //정렬 Map
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 1; i < N+1; i++){
            map.put(i,result[i]);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey)) // 1순위 : value 내림차순 , 2순위 : key 오름차순
                .mapToInt(Map.Entry::getKey) // Integer 키 값을 int 타입의 스트림으로 변환
                .toArray();
    }

    private int[] bestPractice(int N, int[] stages){
        int[] stageCount = new int[N + 2];

        for(int s : stages){
            stageCount[s]++;
        }

        int players = stages.length;

        Map<Integer, Double> failRate = new HashMap<>();

        for(int i = 1; i <= N; i++){

            if(players == 0){
                failRate.put(i, 0.0);
            }else{
                failRate.put(i, (double) stageCount[i] / players);
                players -= stageCount[i];
            }

        }

        return failRate.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry::getKey))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
