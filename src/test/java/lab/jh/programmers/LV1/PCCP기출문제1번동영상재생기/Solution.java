package lab.jh.programmers.LV1.PCCP기출문제1번동영상재생기;


/**
 * Problem: 동영상재생기
 * Level: 1
 *
 * @author 이종현
 * @date 2026-04-20
 * @category 구현
 * @description
 */
class Solution {
    public static void main(String[] args) {
        String video_len1 = "34:33";
        String pos1 = "13:00";
        String op_start1 = "00:55";
        String op_end1 = "02:55";
        String[] commands1 = new String[]{"next", "prev"};
        String answer1 = "13:00";
        String result1 = new Solution().solution(video_len1, pos1, op_start1, op_end1, commands1);
        PRINT_RESULT(1, result1, answer1);

        String video_len2 = "10:55";
        String pos2 = "00:05";
        String op_start2 = "00:15";
        String op_end2 = "06:55";
        String[] commands2 = new String[]{"prev", "next", "next"};
        String answer2 = "06:55";
        String result2 = new Solution().solution(video_len2, pos2, op_start2, op_end2, commands2);
        PRINT_RESULT(2, result2, answer2);

        String video_len3 = "07:22";
        String pos3 = "04:05";
        String op_start3 = "00:15";
        String op_end3 = "04:07";
        String[] commands3 = new String[]{"next"};
        String answer3 = "04:17";
        String result3 = new Solution().solution(video_len3, pos3, op_start3, op_end3, commands3);
        PRINT_RESULT(3, result3, answer3);
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

    int video_len, pos, op_start, op_end;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        init(video_len, pos, op_start, op_end);

        this.pos = skip(this.pos);
        for (String command : commands) {
            switch (command) {
                case "next":
                    this.pos = next(this.pos);
                    break;
                case "prev":
                    this.pos = prev(this.pos);
                    break;
            }

            this.pos = skip(this.pos);
        }

        return convertTime(this.pos);
    }

    private void init(String video_len, String pos, String op_start, String op_end) {
        this.video_len = convertTime(video_len);
        this.pos = convertTime(pos);
        this.op_start = convertTime(op_start);
        this.op_end = convertTime(op_end);
    }

    private int next(int time) {
        time += 10;

        if (time % 100 >= 60) {
            time += 40;
        }

        if (time >= video_len) {
            time = video_len;
        }

        return time;
    }

    private int prev(int time) {
        time -= 10;

        if (time % 100 >= 60) {
            time -= 40;
        }

        if (time <= 0) {
            time = 0;
        }

        return time;
    }

    private int skip(int time) {
        if (time >= op_start && time <= op_end) {
            return op_end;
        }

        return time;
    }

    private int convertTime(String time) {
        String[] times = time.split(":");

        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);

        return hour * 100 + minute;
    }

    private String convertTime(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return String.format("%02d:%02d", hour, minute);
    }
}