package lab.jh.programmers.LV1.중요한_단어를_스포_방지;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.solution("here is muzi here is a secret message", new int[][]{{0, 3}, {23, 28}}));
    }

    static class Solution {
        public int solution(String message, int[][] spoiler_ranges) {
            int answer = 0;
            int len = message.length();
            Set<String> presentWords = new HashSet<>();
            Set<String> spoilerWords = new HashSet<>();

            boolean[] spoilerRanges = new boolean[len];
            for (int[] spoilerRange : spoiler_ranges) {
                int start = spoilerRange[0];
                int end = spoilerRange[1];

                for (int i = start; i <= end; i++) {
                    spoilerRanges[i] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            boolean isSpoiler = false;
            for (int i = 0; i < len; i++) {
                if (message.charAt(i) == ' ') {
                    if (isSpoiler) {
                        spoilerWords.add(sb.toString());
                    } else {
                        presentWords.add(sb.toString());
                    }

                    sb.setLength(0);
                    isSpoiler = false;
                    continue;
                }

                sb.append(message.charAt(i));
                isSpoiler = !isSpoiler ? spoilerRanges[i] : isSpoiler;
            }

            if (isSpoiler) {
                spoilerWords.add(sb.toString());
            } else {
                presentWords.add(sb.toString());
            }

            for (String spoilerWord : spoilerWords) {
                if (!presentWords.contains(spoilerWord)) {
                    answer++;
                }
            }

            return answer;
        }
    }
}
