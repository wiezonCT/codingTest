package lab.wy.backjoon.최대최소;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class Boj2562 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        for (int i = 1; i <= 9; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number > max) {
                max      = number;
                maxIndex = i;
            }
        }

        //결과
        System.out.println(max);
        System.out.println(maxIndex);
    }
}
