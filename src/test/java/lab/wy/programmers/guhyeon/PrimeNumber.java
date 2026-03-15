package lab.wy.programmers.guhyeon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class PrimeNumber {


    @Test
    void test(){
        Assertions.assertEquals(0, solution("01"));
        Assertions.assertEquals(3, solution("17"));
        Assertions.assertEquals(2, solution("011"));

        Assertions.assertEquals(3, bestPractice("17"));
        Assertions.assertEquals(2, bestPractice("011"));
    }


    private Set<Integer> primeNumbers;
    private int solution(String number) {
        primeNumbers = new HashSet<>();
        String[] split = number.split("");

        // 합칠 문자열
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[split.length];

        recursive(sb, split, visited);

        Predicate<Integer> predicate = num -> {
            if(num < 2) return false;

            // 소수 판별식
            for(int i = 2; i * i <= num; i++){
                if(num % i == 0) return false;
            }

            return true;
        };

        List<Integer> list = primeNumbers.stream()
                .filter(predicate)
                .toList();

        return list.size();
    }

    private void recursive(StringBuilder sb, String[] split,  boolean[] visited) {

        if(!sb.isEmpty()){
            primeNumbers.add(Integer.parseInt(sb.toString()));
        }

        for(int i = 0; i < split.length; i++){

            if(visited[i]) continue;

            visited[i] = true;

            sb.append(split[i]);

            recursive(sb, split, visited);

            sb.deleteCharAt(sb.length() - 1); // 백트래킹

            visited[i] = false;
        }
    }



    private Set<Integer> numbers;
    private int bestPractice(String _numbers){
        numbers = new HashSet<>();
        boolean[] visited = new boolean[_numbers.length()];

        dfs("", _numbers, visited);

        int count = 0;

        for(int num : this.numbers){
            if(isPrime(num)){
                count++;
            }
        }

        return count;
    }

    private void dfs(String current, String numbers, boolean[] visited){
        if(!current.isEmpty()){
            this.numbers.add(Integer.parseInt(current));
        }

        for(int i = 0; i < numbers.length(); i++){

            if(visited[i]) continue;

            visited[i] = true;

            dfs(current + numbers.charAt(i), numbers, visited);

            visited[i] = false; // 백트래킹
        }
    }
    private boolean isPrime(int n){

        if(n < 2) return false;

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
