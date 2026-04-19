package lab.jh.programmers.LV1.유연근무제;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] schedules1 = new int[]{700, 800, 1100};
        int[][] timelogs1 = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday1 = 5;
        int answer1 = 3;
        int result1 = new Solution().solution(schedules1, timelogs1, startday1);
        PRINT_RESULT(1, result1, answer1);

        int[] schedules2 = new int[]{730, 855, 700, 720};
        int[][] timelogs2 = new int[][]{{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
        int startday2 = 1;
        int answer2 = 2;
        int result2 = new Solution().solution(schedules2, timelogs2, startday2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        schedules = getEventSchedules(schedules);
        boolean[] holidays = getHolidays(startday);

        for (int i = 0; i < timelogs.length; i++) {
            int schedule = schedules[i];
            int[] timelog = timelogs[i];
            boolean isSuccess = true;
            for (int j = 0; j < timelog.length; j++) {
                if (schedule < timelog[j] && !holidays[j]) {
                    isSuccess = false;
                    break;
                }
            }

            if (isSuccess) {
                answer++;
            }
        }

        return answer;
    }

    private int[] getEventSchedules(int[] schedules) {
        for (int i = 0; i < schedules.length; i++) {
            int time = schedules[i] + 10;
            int minute = time % 100;

            if (minute >= 60) {
                time += 40;
            }

            schedules[i] = time;
        }

        return schedules;
    }

    private boolean[] getHolidays(int startDay) {
        boolean[] holidays = new boolean[7];

        List<Integer> holidayList = List.of(0, 6);
        for (int i = 0; i < 7; i++) {
            holidays[i] = holidayList.contains(startDay++ % 7);
        }

        return holidays;
    }
}