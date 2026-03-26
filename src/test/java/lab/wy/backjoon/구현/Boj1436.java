package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj1436 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 0;
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            if(String.valueOf(i).contains("666")){
                count++;
                if(count == num){
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}