package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj15650 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrayLength = Integer.parseInt(st.nextToken());
        int choiceCount = Integer.parseInt(st.nextToken());


        boolean[] array = new boolean[arrayLength+1];
        int[] out = new int[choiceCount];
        StringBuilder result = new StringBuilder();

//        dfs(0, array, out, choiceCount, result);
        bestPractice(0, 1, array, out, choiceCount, result);
        System.out.println(result);

    }

    private static void dfs(int depth, boolean[] visited, int[] out, int choiceCount, StringBuilder result){
        if(depth  == choiceCount){
            // 배열 정렬 (깊은 복사 사용)
            int[] temp = Arrays.copyOf(out, out.length);
            Arrays.sort(temp);

            StringBuilder compare = new StringBuilder();
            for(int i = 0; i < temp.length; i++){
                if(i == temp.length -1){
                    compare.append(temp[i]);
                }else{
                    compare.append(temp[i]).append(" ");
                }
            }

            // compare 기존에 있는지 체크 (중복 제거)
            if(!result.toString().contains(compare.toString())){
                if(result.isEmpty()){
                    result.append(compare);
                }else{
                    result.append("\n").append(compare);
                }
            }

            return;
        }

        for(int j = 1; j < visited.length; j++){
            if(!visited[j]){
                visited[j] = true;
                out[depth] = j;
                dfs(depth+1, visited, out, choiceCount, result);

                // 원복
                visited[j] = false;
            }
        }

    }

    private static void bestPractice(int depth, int start, boolean[] visited, int[] out, int choiceCount, StringBuilder result){
        if(depth  == choiceCount){
            /**
             * 삭제) 배열 정렬 (깊은 복사 사용) >> 매우 비효율 매번 발생
             */
            for(int i = 0; i < out.length; i++){
                if(i == out.length -1){
                    result.append(out[i]).append("\n");
                }else{
                    result.append(out[i]).append(" ");
                }
            }

            return;
        }

        for(int j = start; j < visited.length; j++){
            if(!visited[j]){
                visited[j] = true;
                out[depth] = j;
                /**
                 * 지금 정한 j값보다 큰 수에서만 찾기 (정렬할 필요 없음)
                 */
                bestPractice(depth+1, j+1,visited, out, choiceCount, result);

                // 원복
                visited[j] = false;
            }
        }

    }
}