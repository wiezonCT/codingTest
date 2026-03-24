package lab.wy.backjoon.구현;

import java.io.*;
import java.util.*;

public class Boj1316 {

    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number  = Integer.parseInt(br.readLine());
        int count   = 0;

        for (int i = 0; i < number; i++) {
            String checkString = br.readLine();

            if (isGroupWord(checkString)){
                count++;
            }

        }

        System.out.println(count);

    }

    private static boolean isGroupWord(String checkString) {

        List<Character> words = new ArrayList<>();
        char beforeWord = '0';

        for (int i = 0; i < checkString.length(); i++) {

            char c = checkString.charAt(i);

            // 이전값이 있고, 같지 않을경우 list add
            if (beforeWord != '0' && beforeWord != c) {

                beforeWord = c;

                // words 포함되어있는지 체크 (그룹이 아니면 바로 false)
                if (!words.contains(c)) {
                    words.add(c);
                } else {
                    return false;
                }

            } else if (beforeWord == '0') {
                beforeWord = c;
                words.add(c);
            } else {
                // 붙어있는 같은 값은 패스
                continue;
            }
        }

        return true;
    }

    private static boolean bestPratice_isGroupWord(String checkString) {
        // 알파벳 a~z (26개)의 등장 여부를 체크할 배열
        boolean[] seen = new boolean[26];
        char beforeWord = '0';

        for (int i = 0; i < checkString.length(); i++) {
            char c = checkString.charAt(i);

            // 이전 문자와 다른 새로운 문자가 나타났을 때
            if (beforeWord != c) {
                // 해당 문자가 이미 등장한 적이 있다면 그룹 단어가 아님
                if (seen[c - 'a']) {
                    return false;
                }

                // 처음 등장한 문자라면 방문 처리 및 beforeWord 갱신
                seen[c - 'a'] = true;
                beforeWord = c;
            }
            // 이전 문자와 같다면 아무것도 하지 않고 패스 (else 생략 가능)
        }

        return true;
    }
}