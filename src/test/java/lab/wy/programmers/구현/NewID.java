package lab.wy.programmers.구현;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewID {
    @Test
    void test(){
        Assertions.assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
        Assertions.assertEquals("z--", solution("z-+.^."));
        Assertions.assertEquals("aaa", solution("=.="));
        Assertions.assertEquals("123_.def", solution("123_.def"));
        Assertions.assertEquals("abcdefghijklmn", solution("abcdefghijklmn.p"));

        Assertions.assertEquals("bat.y.abcdefghi", bestPractice("...!@BaT#*..y.abcdefghijklm"));
        Assertions.assertEquals("z--", bestPractice("z-+.^."));
        Assertions.assertEquals("aaa", bestPractice("=.="));
        Assertions.assertEquals("123_.def", bestPractice("123_.def"));
        Assertions.assertEquals("abcdefghijklmn", bestPractice("abcdefghijklmn.p"));
    }

    private String solution(String newId) {
        // 1단계
        newId = newId.toLowerCase();
        // 2단계
        String regex = "[^a-z0-9-_.]*";
        newId = newId.replaceAll(regex, "");
        // 3단계
        StringBuilder sb = new StringBuilder();
        boolean isDot = false;
        for(int i = 0; i < newId.length(); i++) {

            char c = newId.charAt(i);
            if(c == '.'){
                isDot = true;
            }else{
                if(isDot){
                    sb.append('.');
                    isDot = false;
                }
                sb.append(c);
            }

        }
        newId = sb.toString();

        //4단계
        if(!newId.isEmpty() && newId.charAt(0) == '.'){
            newId = newId.substring(1);
        }
        if(!newId.isEmpty() && newId.charAt(newId.length()-1) == '.'){
            newId = newId.substring(0, newId.length()-1);
        }

        // 5 단계
        if(newId.isEmpty()){
            newId = "a";
        }

        // 6단계
        if(newId.length() > 15){
            newId = newId.substring(0, 15);
        }
        if(!newId.isEmpty() && newId.charAt(newId.length()-1) == '.'){
            newId = newId.substring(0, newId.length()-1);
        }

        // 7단계
        if(newId.length() < 3){
            char append = newId.charAt(newId.length()-1);
            StringBuilder newIdBuilder = new StringBuilder(newId);
            for(int i = newId.length(); i < 3; i++){
                newIdBuilder.append(append);
            }
            newId = newIdBuilder.toString();
        }

        return newId;
    }

    private String bestPractice(String newId) {

        // 1
        newId = newId.toLowerCase();

        // 2
        newId = newId.replaceAll("[^a-z0-9-_.]", "");

        // 3
        newId = newId.replaceAll("[.]{2,}", ".");

        // 4
        newId = newId.replaceAll("^[.]|[.]$", "");

        // 5
        if(newId.isEmpty()){
            newId = "a";
        }

        // 6
        if(newId.length() > 15){
            newId = newId.substring(0, 15);
            newId = newId.replaceAll("[.]$", "");
        }

        // 7
        while(newId.length() < 3){
            newId += newId.charAt(newId.length()-1);
        }

        return newId;
    }
}
