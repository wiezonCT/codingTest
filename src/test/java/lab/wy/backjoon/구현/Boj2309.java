package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj2309 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. 숫자 저장
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
        }


        // 2. boolean 배열 생성
        boolean[] isBoolean = new boolean[101];
        for (int i = 0; i < numbers.size(); i++) {
            isBoolean[numbers.get(i)] = true;
        }

        // 2가지 숫자 제외 2중 for문
        for (int i = 0; i < numbers.size(); i++) {
            // 첫번째 난쟁이 제외
            isBoolean[numbers.get(i)] = false;
            for (int j = 0; j < numbers.size(); j++) {

                // 두번째 난쟁이 제외
                if (i == j) continue;
                isBoolean[numbers.get(j)] = false;

                // if : 합계 100
                int sum = 0;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < 101; k++) {
                    if (isBoolean[k]) {
                        sum += k;
                        sb.append(k).append("\n");
                    }
                }

                if (sum == 100) {
                    System.out.println(sb);
                    return;
                }

                // 두번째 난쟁이 원복 >> 다음으로
                isBoolean[numbers.get(j)] = true;

            }

            // 첫번째 난쟁이 원복 >> 다음으로
            isBoolean[numbers.get(i)] = true;
        }


    }
}