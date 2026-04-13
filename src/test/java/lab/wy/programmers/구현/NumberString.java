package lab.wy.programmers.구현;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

public class NumberString {
    @Test
    void test(){
        Assertions.assertEquals(1478, solution("one4seveneight"));
        Assertions.assertEquals(234567, solution("23four5six7"));
        Assertions.assertEquals(234567, solution("2three45sixseven"));
        Assertions.assertEquals(123, solution("123"));

        Assertions.assertEquals(1478, bestPractice("one4seveneight"));
        Assertions.assertEquals(234567, bestPractice("23four5six7"));
        Assertions.assertEquals(234567, bestPractice("2three45sixseven"));
        Assertions.assertEquals(123, bestPractice("123"));
    }

    private int solution(String str){
        Map<String, Integer> numberMap = Map.ofEntries(
                Map.entry("zero", 0),
                Map.entry("one", 1),
                Map.entry("two", 2),
                Map.entry("three", 3),
                Map.entry("four", 4),
                Map.entry("five", 5),
                Map.entry("six", 6),
                Map.entry("seven", 7),
                Map.entry("eight", 8),
                Map.entry("nine", 9),
                Map.entry("ten", 10)
        );

        char[] charArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArray.length; i++){

            char ch = charArray[i];
            //숫자가 아니고, number 문자가 아닌경우
            if(((int)ch > 57 || (int) ch < 48) && !numberMap.containsKey(sb.toString())){
                sb.append(ch);
                if(i == charArray.length - 1){
                    result.append(numberMap.get(sb.toString()));
                }
            } else{
                if(!sb.isEmpty()){
                    result.append(numberMap.get(sb.toString()));
                    sb = new StringBuilder();
                    if((int)ch > 57 || (int)ch < 48){
                        sb.append(ch);
                    }else{
                        result.append(ch);
                    }
                }else{
                    result.append(ch);
                }
            }
        }
        return Integer.parseInt(result.toString());
    }

    private Integer bestPractice(String s){
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
