package lab.wy.backjoon.최대최소;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static lab.wy.backjoon.최대최소.Boj10818.bestPractice;
import static lab.wy.backjoon.최대최소.Boj10818.solution;

public class Boj10818Test {

    @Test
    void test() {
        Assertions.assertEquals("7 35", solution("5", "20 10 35 30 7"));
        Assertions.assertEquals("7 35", bestPractice("5", "20 10 35 30 7"));
    }
}
