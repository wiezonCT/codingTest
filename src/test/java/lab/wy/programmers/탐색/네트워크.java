package lab.wy.programmers.탐색;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크 {

    @Test
    void test() {
        Assertions.assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }


    private int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 첫 방문이다
                count++;
//                dfs(i, n, visited, computers);
                bfs(i, n, visited, computers);
            }
        }


        return count;
    }


    private void dfs(int i, int n, boolean[] visited, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < n; j++) {
            // 1. 자기 자신 아니고,
            // 2. 방문 안했어고,
            // 3. 연결되어있으면,
            if (i != j && !visited[j] && computers[i][j] == 1) {
                dfs(j, n, visited, computers);
            }
        }
    }



    private void bfs(int start, int n, boolean[] visited, int[][] computers){
        Queue<Integer> queue = new ArrayDeque();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();

            for(int i = 0; i < n; i++){
                if(current != i && computers[current][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }

        }
    }
}
