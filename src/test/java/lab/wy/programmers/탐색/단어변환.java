package lab.wy.programmers.탐색;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 단어변환 {

    @Test
    void test() {
        Assertions.assertEquals(4, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        Assertions.assertEquals(0, solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }


    private int solution(String begin, String target, String[] words) {
        // 1. target이 words 안에 없는 경우 빠른 종료 (스트림 대신 간단한 contains 활용)
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        // 2. 단 한 번의 BFS 호출
        return bfs(begin, target, words);

    }

    private int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<WordState> queue = new ArrayDeque<>();

        queue.add(new WordState(begin, 0));

        while (!queue.isEmpty()) {
            WordState current = queue.poll();
            String currentWord = current.word;
            int currentCount = current.index;

            // 4. 타겟 단어에 도달하면 누적 횟수 반환
            if (currentWord.equals(target)) {
                return currentCount;
            }

            // 5. 다음 변환할 단어를 찾아 큐에 삽입
            insertQueue(currentWord, currentCount, queue, visited, words);
        }

        return 0;
    }

    private void insertQueue(String currentWord, int currentCount, Queue<WordState> queue,boolean[] visited, String[] words){
        for (int i = 0; i < words.length; i++) {
            // 방문하지 않았고, 1글자 차이인 단어 찾기
            if (!visited[i] && changeWordCount(currentWord, words[i]) == 1) {
                queue.add(new WordState(words[i], currentCount + 1)); // 누적 횟수 1 증가하여 큐에 넣기
                visited[i] = true; // 큐에 넣음과 동시에 방문 처리
            }
        }
    }


    private int changeWordCount(String begin, String target) {
        int count = 0;
        for (int i = 0; i < target.length(); i++) {
            if (begin.charAt(i) != target.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public static class WordState{
        public String word;
        public int index;

        public WordState(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
