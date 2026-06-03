package lab.wy.programmers.탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 경주로건설 {

    @Test
    void test(){
        Assertions.assertEquals(900, solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }

    private int solution(int[][] board) {
        return bfs(board);
    }


    private int bfs(int[][] board){

        Queue<Data> queue = new ArrayDeque<>();
        int[][][] visited = new int[board.length][board[0].length][4];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }


        int[] directionRow = {-1, 1, 0, 0};
        int[] directionCol = {0, 0, -1, 1};

        int maxRow = board.length;
        int maxCol = board[0].length;
        int minRow = -1;
        int minCol = -1;


        queue.offer(new Data(0,0,-1,0));

        while(!queue.isEmpty()){
            Data poll = queue.poll();
            int row = poll.row;
            int col = poll.col;
            int beforeDir = poll.before;
            int count = poll.count;

            for(int i = 0; i < 4; i++){
                int nextRow = row + directionRow[i];
                int nextCol = col + directionCol[i];
                int nextDir = i;

                if(nextRow > minRow && nextRow < maxRow && nextCol > minCol && nextCol < maxCol && board[nextRow][nextCol] != 1){
                    int nextCount = count;

                    if(beforeDir == -1 || beforeDir == nextDir){
                        nextCount += 100;
                    }else{
                        nextCount += 600;
                    }

                    if(visited[nextRow][nextCol][nextDir] >= nextCount){
                        visited[nextRow][nextCol][nextDir] = nextCount;
                        queue.offer(new Data(nextRow,nextCol,nextDir,nextCount));
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            if(min >= visited[maxRow -1][maxCol -1][i]) min = visited[maxRow -1][maxCol -1][i];
        }

        return min;
    }


    private static class Data{
        public int row;
        public int col;
        public int before;
        public int count;

        public Data(int row, int col, int before, int count){
            this.row = row;
            this.col = col;
            this.before = before;
            this.count = count;
        }

    }
}
