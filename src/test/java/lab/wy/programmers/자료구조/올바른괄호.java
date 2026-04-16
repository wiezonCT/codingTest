package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른괄호 {

    @Test
    void test(){
        Assertions.assertTrue(solution("(())"));
        Assertions.assertTrue(solution("()"));
        Assertions.assertTrue(solution("()()"));
        Assertions.assertFalse(solution("()("));
    }


    private boolean solution(String input){

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if(temp == '('){
                stack.push(temp);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
