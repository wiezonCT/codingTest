package lab.jh.programmers.LV1.노란불_신호등;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{2, 1, 2}, {5, 1, 1}}));
    }

    static class Solution {
        public int solution(int[][] signals) {
            int n = signals.length;
            int[] cycles = new int[n];

            for (int i = 0; i < n; i++) {
                cycles[i] = signals[i][0] + signals[i][1] + signals[i][2];
            }

            long lcm = cycles[0];
            for (int i = 1; i < n; i++) {
                lcm = getLCM(lcm, cycles[i]);
            }

            for (long t = 0; t < lcm; t++) {
                boolean isAllYellow = true;

                for (int i = 0; i < n; i++) {
                    int green = signals[i][0];
                    int yellow = signals[i][1];
                    int cycle = cycles[i];

                    long currentPhase = t % cycle;

                    if (!(currentPhase >= green && currentPhase < green + yellow)) {
                        isAllYellow = false;
                        break;
                    }
                }

                if (isAllYellow) {
                    return (int) (t + 1);
                }
            }

            return -1;
        }

        private long getGCD(long a, long b) {
            while (b != 0) {
                long r = a % b;
                a = b;
                b = r;
            }
            return a;
        }

        private long getLCM(long a, long b) {
            return a / getGCD(a, b) * b;
        }
    }
}