package lab.wy.backjoon.구현;

import java.io.*;
import java.math.RoundingMode;
import java.util.*;

public class Boj1475 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int[] numList = new int[10];

        for(int i = 0; i < number.length(); i++){
            int c = number.charAt(i) - '0';

            if(c >= 0 && c < 10){
                numList[c]++;
            }

        }


        int exludeSixAndNineMaxCount = 0;
        int sixAndNineMaxCount = 0;

        for(int i = 0; i < 10; i++){
            int tempNum = numList[i];
            if(i == 6 || i == 9){
                sixAndNineMaxCount += tempNum;
            }else{
                exludeSixAndNineMaxCount = Math.max(exludeSixAndNineMaxCount, tempNum);
            }
        }

        // 6과 9 합산이 홀수일 경우, 세트가 짝수일경우 + 1 이므로 올림처리
        int max = Math.max(exludeSixAndNineMaxCount, (sixAndNineMaxCount +1) / 2);
        System.out.println(max);


    }
}