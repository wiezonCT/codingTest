package lab.wy.programmers.guhyeon;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// 구현 문제
// 모의고사
public class mock_exam {

    @Test
    void test(){
        int[] array = {1,2,3,4,5};
        Assertions.assertEquals(List.of(1), solution(array));
        Assertions.assertEquals(List.of(1), bestPractice(array));
    }

    private List<Integer> solution(int[] param){
        List<Integer> maxSuccessList = new ArrayList<>();

        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};

        int person1Count = 0;
        int person2Count = 0;
        int person3Count = 0;
        for(int i = 0; i < param.length; i++){
            if(param[i] == person1[i%person1.length]){
                person1Count++;
            }
            if(param[i] == person2[i%person2.length]){
                person2Count++;
            }
            if(param[i] == person3[i%person3.length]){
                person3Count++;
            }
        }

        int max = Math.max(person1Count, person2Count);
        max = Math.max(max, person3Count);

        if(max == person1Count) maxSuccessList.add(1);
        if(max == person2Count) maxSuccessList.add(2);
        if(max == person3Count) maxSuccessList.add(3);

        return maxSuccessList;
    }



    private List<Integer> bestPractice(int[] answers) {

        int[][] persons = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        int[] scores = new int[persons.length];

        for(int i = 0; i < answers.length; i++){
            for(int j = 0; j < persons.length; j++){
                if(answers[i] == persons[j][i % persons[j].length]){
                    scores[j]++;
                }
            }
        }

        int max = 0;
        for(int score : scores){
            max = Math.max(max, score);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == max){
                result.add(i+1);
            }
        }

        return result;
    }
}
