package lab.jh.programmers.LV2.호텔대실;

class Refactor {
    public static void main(String[] args) {
        String[][] book_time1 = new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int answer1 = 3;
        int result1 = new Refactor().solution(book_time1);
        PRINT_RESULT(1, result1, answer1);

        String[][] book_time2 = new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}};
        int answer2 = 1;
        int result2 = new Refactor().solution(book_time2);
        PRINT_RESULT(2, result2, answer2);

        String[][] book_time3 = new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        int answer3 = 3;
        int result3 = new Refactor().solution(book_time3);
        PRINT_RESULT(3, result3, answer3);
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

    public int solution(String[][] book_time) {
        int[] times = new int[60 * 24 + 11];

        for (String[] book : book_time) {
            times[parseTime(book[0])]++;
            times[parseTime(book[1]) + 10]--;
        }

        return prefixSum(times);
    }

    private int prefixSum(int[] times) {
        int answer = -1;

        int count = 0;
        for (int i = 0; i < times.length; i++) {
            count += times[i];
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private int parseTime(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}