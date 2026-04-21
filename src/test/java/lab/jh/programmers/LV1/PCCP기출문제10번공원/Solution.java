package lab.jh.programmers.LV1.PCCP기출문제10번공원;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };

        String answer1 = "3";
        String result1 = new lab.jh.programmers.LV1.PCCP기출문제10번공원.Solution().solution(mats, park) + "";
        PRINT_RESULT(1, result1, answer1);

        int[] mats2 = {1, 2};
        String[][] park2 = {
                {"A", "-1"},
                {"A", "-1"}
        };

        String answer2 = "1";
        String result2 = new lab.jh.programmers.LV1.PCCP기출문제10번공원.Solution().solution(mats2, park2) + "";
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    String[][] park;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;

        init(park);
        Arrays.sort(mats);
        for (int mat : mats) {
            boolean isAvailable = false;
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[i].length; j++) {
                    if (park[i][j].equals("-1")) {
                        isAvailable = isAvailableMatPut(i, j, mat);
                    }

                    if (isAvailable) {
                        answer = mat;
                        break;
                    }
                }

                if (isAvailable) {
                    break;
                }
            }

            if (!isAvailable) {
                break;
            }
        }

        return answer == 0 ? -1 : answer;
    }

    private void init(String[][] park) {
        this.park = park;
    }

    private boolean isAvailableMatPut(int i, int j, int mat) {
        for (int y = i; y < i + mat; y++) {
            for (int x = j; x < j + mat; x++) {
                if (y == park.length || x == park[i].length) {
                    return false;
                }

                if (!park[y][x].equals("-1")) {
                    return false;
                }
            }
        }

        return true;
    }
}
