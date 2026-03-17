package lab.wy.backjoon.최대최소;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Boj10818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        String numArray = br.readLine();

        System.out.println(solution(numStr, numArray));
    }

    public static String solution(String numStr, String arrayStr){
        int num = Integer.parseInt(numStr);
        String[] splits = arrayStr.split(" ");

        List<Integer> arrayNum = Arrays.stream(splits)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        arrayNum.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        sb.append(arrayNum.get(0));
        sb.append(" ");
        sb.append(arrayNum.get(num-1));

        return sb.toString();
    }

    public static String bestPractice(String numStr, String arrayStr){

        String[] splits = arrayStr.split(" ");

        int current;
        int min = Integer.parseInt(splits[0]);
        int max = Integer.parseInt(splits[0]);
        for(int i = 0; i <Integer.parseInt(numStr); i++){
            current = Integer.parseInt(splits[i]);
            if(current < min){
                min = current;
            }
            if(current > max){
                max = current;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);

        return sb.toString();
    }

}
