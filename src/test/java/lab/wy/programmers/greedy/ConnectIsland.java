package lab.wy.programmers.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ConnectIsland {

    @Test
    public void test(){
        //[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
        Assertions.assertEquals(4, Solution(4, new int[][]{{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}));
    }

    public boolean[] visited;
    List<Item>[] arr;
    public int minCost = Integer.MAX_VALUE;

    private int Solution(int n, int[][] costs){
        visited = new boolean[n];
        arr = new ArrayList[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }
        // 1차원 배열 정리
        // 1 -> 0,1
        // 2 -> 3
        // ...
        for (int[] cost : costs) {
            arr[cost[0]].add(new Item(cost[1], cost[2]));
            arr[cost[1]].add(new Item(cost[0], cost[2]));
        }


        //dfs
        visited[0] = true;
        dfs(0,1, n);


        return minCost;
    }

    private void dfs(int currentCost, int connectedCount, int totalIslandCount){


        //종료 조건 (모든 섬을 다 연결했다면)
        if(connectedCount == totalIslandCount){
            minCost = Math.min(minCost, currentCost);
            return;
        }

        // 탐색 (순회)
        for (int i = 0; i <  totalIslandCount; i++) {
            if(!visited[i])
                continue;

            for(Item next : arr[i]){
                if(!visited[next.island]){
                    visited[next.island] = true;
                    dfs(currentCost + next.cost, connectedCount + 1, totalIslandCount);
                    visited[next.island] = false;
                }
            }
        }

    }


    public class Item{
        public int island;
        public int cost;

        public Item(int island, int cost){
            this.island = island;
            this.cost = cost;
        }
    }
}
