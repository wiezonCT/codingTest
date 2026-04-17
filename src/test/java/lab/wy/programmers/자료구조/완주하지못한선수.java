package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 완주하지못한선수 {


    @Test
    void test() {
        Assertions.assertEquals("leo", solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            participantMap.put(participant[i], participantMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            participantMap.put(completion[i], participantMap.getOrDefault(completion[i], 0) - 1);
            if (participantMap.get(completion[i]) == 0) {
                participantMap.remove(completion[i]);
            }
        }

        Set<Map.Entry<String, Integer>> entries = participantMap.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            return entry.getKey();
        }

        return null;
    }
}
