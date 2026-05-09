package lab.jh.programmers.LV2.호텔대실;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        String[][] book_time1 = new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int answer1 = 3;
        int result1 = new Solution().solution(book_time1);
        PRINT_RESULT(1, result1, answer1);

        String[][] book_time2 = new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}};
        int answer2 = 1;
        int result2 = new Solution().solution(book_time2);
        PRINT_RESULT(2, result2, answer2);

        String[][] book_time3 = new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        int answer3 = 3;
        int result3 = new Solution().solution(book_time3);
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
        List<Room> rooms = init(book_time);
        return searchNeedRoomCounts(rooms);
    }

    private List<Room> init(String[][] book_time) {
        List<Room> rooms = new ArrayList<>();

        for (String[] book : book_time) {
            rooms.add(new Room(book));
        }

        rooms.sort(Comparator.comparing(room -> room.start));
        return rooms;
    }

    private int searchNeedRoomCounts(List<Room> rooms) {
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.add(rooms.get(0));

        for (int i = 1; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            Room temp = pq.peek();

            if (temp.end > room.start) {
                pq.add(room);
                continue;
            }

            pq.poll();
            pq.add(room);
        }

        return pq.size();
    }

    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(String[] time) {
            String[] start_time = time[0].split(":");
            String[] end_time = time[1].split(":");
            this.start = Integer.parseInt(start_time[0]) * 60 + Integer.parseInt(start_time[1]);
            this.end = Integer.parseInt(end_time[0]) * 60 + Integer.parseInt(end_time[1]) + 10;
        }

        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }
    }
}