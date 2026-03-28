package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj1018 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    /**
     * 문제 해결 벙법)
     * 0. 입력값 >> 배열로 저장
     * 1. 8 * 8 크기가 가능한 곳의 출발지 부터 count 체크 (출발지 색깔 지정 -> 바꾼결과와 안바꾼결과)
     * 2. count 리스트에서 최소값 찾기
     * 3. 결과 반환
     */
    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken(" "));
        int width = Integer.parseInt(st.nextToken(" "));

        // Black : 1 , White : 0
        int[][] board = new int[height][width];
        for ( int i = 0; i < height; i++ ){
            String line = br.readLine();
            for( int j = 0; j < width; j++ ){
                if(line.charAt(j) == 'B'){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }

        int[][] startBlack = new int[][]{{1,0,1,0,1,0,1,0}, {0,1,0,1,0,1,0,1}};
        int[][] startWhite = new int[][]{{0,1,0,1,0,1,0,1}, {1,0,1,0,1,0,1,0}};

        // ================ [ Core ] ===================

        List<Integer> counts = new ArrayList<>();
        counts.add(Integer.MAX_VALUE);
        // 시작 지점이 가능한 곳
        for (int i = 0; i <= height - 8; i++) {
            for(int j = 0; j <= width - 8; j++){
                // white 시작
                counts.add(getTransCount(i, j, board, startWhite));

                // black 시작
                counts.add(getTransCount(i, j, board, startBlack));
            }
        }



        //counts 최소값
        Integer min = counts.stream()
                .min(Comparator.comparing(x -> x))
                .orElseThrow();

        System.out.println(min);
    }

    private static int getTransCount(int heightWidth, int startWidth, int[][] originBoard, int[][] compareBoard) {
        int count = 0;
        for (int i = heightWidth; i < heightWidth + 8; i++) {
            for (int j = startWidth; j < startWidth + 8; j++) {
                if(originBoard[i][j] != compareBoard[i%2][j%8]){
                    count++;
                }
            }
        }

        return count;
    }
}