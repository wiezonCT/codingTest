package lab.wy.backjoon.구현;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15649 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arraySize = Integer.parseInt(st.nextToken());
        int choiceCount = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[arraySize+1];


        /**
         * 1. 전체 배열 반복 필요
         * 2. 해당 반복시, visited 한 개수이면 pass
         * 3. choiceCount 까지 반복
         */


        StringBuilder sb = new StringBuilder();
        int[] temp = new int[choiceCount];
        backtracking(0, visited, temp, choiceCount, sb);
        System.out.println(sb);
    }

    public static void backtracking(int depth, boolean[] visited, int[] temp, int choiceCount, StringBuilder result) throws Exception {


        if(depth == choiceCount){
            for(int i = 0; i < temp.length; i++){
                if(i == temp.length-1){
                    result.append(temp[i]);
                }else{
                    result.append(temp[i]).append(" ");
                }
            }
            result.append("\n");
            return;
        }

        for(int i = 1; i < visited.length; i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = i;
                // next depth 구하기
                backtracking(depth+1, visited, temp, choiceCount, result);
                // 원복
                visited[i] = false;
            }
        }

    }
}