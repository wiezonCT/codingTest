package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 베스트엘범 {

    @Test
    void test() {
        Assertions.assertArrayEquals(new int[]{4, 1, 3, 0}, solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
        Assertions.assertArrayEquals(new int[]{4, 1, 3, 0}, bestPractice(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }


    private int[] solution(String[] type, int[] plays) {
        class Song implements Comparable<Song> {
            public int index;
            public int playCount;

            public Song(int index, int playCount) {
                this.index     = index;
                this.playCount = playCount;
            }

            @Override
            public int compareTo(Song otherSong) {
                if (this.playCount != otherSong.playCount) {
                    return Integer.compare(otherSong.playCount, this.playCount);
                }
                return Integer.compare(this.index, otherSong.index);
            }
        }


        Map<String, List<Song>> resultMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < type.length; i++) {
            if (resultMap.containsKey(type[i]) && sumMap.containsKey(type[i])) {
                resultMap.get(type[i]).add(new Song(i, plays[i]));
                sumMap.put(type[i], sumMap.get(type[i]) + plays[i]);
            } else {
                resultMap.put(type[i], new ArrayList<>());
                resultMap.get(type[i]).add(new Song(i, plays[i]));
                sumMap.put(type[i], plays[i]);
            }
        }

        List<Integer> result = new ArrayList<>();

        sumMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(entry -> {
            List<Song> songs = resultMap.get(entry.getKey());
            songs.stream().sorted() // song.playCount  desc + song.index asc
                    .limit(2) // stream 2개까지만
                    .forEach(song -> {
                        result.add(song.index);
                    });
        });

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int[] bestPractice(String[] genres, int[] plays) {
        class Song implements Comparable<Song> {
            public int index;
            public int playCount;

            public Song(int index, int playCount) {
                this.index     = index;
                this.playCount = playCount;
            }

            @Override
            public int compareTo(Song otherSong) {
                if (this.playCount != otherSong.playCount) {
                    return Integer.compare(otherSong.playCount, this.playCount);
                }
                return Integer.compare(this.index, otherSong.index);
            }
        }

        Map<String, List<Song>> genreMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();

        // 1. Map 초기화 최적화 (computeIfAbsent, getOrDefault)
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreMap.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, play));
            playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
        }

        // 2. Stream 파이프라인으로 정렬, 필터링, 배열 변환을 한 번에 처리
        return playMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // 장르 재생수 내림차순 정렬
                .flatMap(entry -> genreMap.get(entry.getKey()).stream()
                        .sorted() // Song 클래스의 compareTo 기준 정렬 (재생수 내림차순 -> 인덱스 오름차순)
                        .limit(2)) // 장르별 최대 2개 추출
                .mapToInt(song -> song.index) // Song 객체에서 고유번호(index)만 추출
                .toArray(); // int[] 배열로 최종 반환
    }
}
