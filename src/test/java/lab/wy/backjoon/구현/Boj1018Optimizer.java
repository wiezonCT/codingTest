package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj1018Optimizer {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        // 메모리와 속도 효율을 위해 boolean 배열 사용 (White: true, Black: false)
        boolean[][] board = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                board[i][j] = (line.charAt(j) == 'W');
            }
        }

        int min = 64; // 8x8 체스판에서 최대로 칠할 수 있는 횟수는 64번

        // 8x8 크기의 시작점이 될 수 있는 곳 순회
        for (int i = 0; i <= height - 8; i++) {
            for (int j = 0; j <= width - 8; j++) {
                // 매번 최솟값 갱신
                min = Math.min(min, getMinRepaint(i, j, board));
            }
        }

        System.out.println(min);
    }

    private static int getMinRepaint(int startRow, int startCol, boolean[][] board) {

        int count = 0;
        boolean expectedColor = true; // 맨 왼쪽 위가 'W'(true)라고 가정

        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if (board[i][j] != expectedColor) {
                    count++;
                }
                // 옆 칸으로 이동하면 기대하는 색상이 반전됨 (W -> B -> W)
                expectedColor = !expectedColor;
            }
            // 8칸(짝수)을 검사하고 다음 줄로 넘어갈 때,
            // 체스판 패턴을 유지하려면 색상이 한 번 더 반전되어야 함
            expectedColor = !expectedColor;
        }

        // 'W'로 시작하는 경우(count)와 'B'로 시작하는 경우(64 - count) 중 최솟값 반환
        return Math.min(count, 64 - count);
    }
}