package lab.wy.programmers.자료구조;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;


public class 다리를지나는트럭 {
    @Test
    void test() {
        Assertions.assertEquals(8, solution(2, 10, new int[]{7, 4, 5, 6}));
    }


    // 지나는 소요 시간 : bridge_length
    // 총 올라갈 수 있는 무게 : weight
    // 총 트럭 무게 리스트
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리에 진입한 시간 시점 기록 QUEUE
        // 트럭 대기 큐
        // bridge_length : 걸리는 시간

        Queue<Integer> inBridgeTime = new ArrayDeque<>();
        Queue<Integer> inBridgeWeight = new ArrayDeque<>();
        Queue<Integer> waitTruckWeight = new ArrayDeque<>();

        for (int i = 0; i < truck_weights.length; i++) {
            waitTruckWeight.offer(truck_weights[i]);
        }

        int currentWeight = 0;
        int currentTime = 0;
        while (!waitTruckWeight.isEmpty() || !inBridgeTime.isEmpty()) {
            if (!inBridgeTime.isEmpty()) {
                if (inBridgeTime.peek() + bridge_length <= currentTime) {
                    currentWeight -= inBridgeWeight.poll();
                    inBridgeTime.poll();
                }
            }
            boolean isInFunc = false;

            while (!waitTruckWeight.isEmpty()) {
                // 트럭진입 가능한지 확인
                if (currentWeight + waitTruckWeight.peek() > weight) {
                    currentTime++;
                    isInFunc = true;
                    break;
                } else {
                    currentWeight += waitTruckWeight.peek();
                    inBridgeWeight.offer(waitTruckWeight.poll());
                    inBridgeTime.offer(currentTime);
                }
            }

            if (!isInFunc) {
                currentTime++;
            }

        }


        return currentTime;
    }

    static class Truck {
        int weight;
        int entryTime;

        Truck(int weight, int entryTime) {
            this.weight = weight;
            this.entryTime = entryTime;
        }
    }

    public int bestSolution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;
        int waitIndex = 0; // 대기 큐를 배열 인덱스로 대체하여 메모리/시간 최적화

        // 대기 중인 트럭이 있거나, 다리 위에 트럭이 남아있다면 계속 시뮬레이션
        while (waitIndex < truck_weights.length || !bridge.isEmpty()) {
            time++; // 💡 패턴 2: 루프 1회 = 1초 경과 (Tick)

            // 1. 다리를 다 건넌 트럭 처리
            if (!bridge.isEmpty()) {
                if (bridge.peek().entryTime + bridge_length == time) {
                    currentWeight -= bridge.poll().weight;
                }
            }

            // 2. 새로운 트럭 진입 처리
            if (waitIndex < truck_weights.length) {
                if (currentWeight + truck_weights[waitIndex] <= weight) {
                    bridge.offer(new Truck(truck_weights[waitIndex], time));
                    currentWeight += truck_weights[waitIndex];
                    waitIndex++;
                }
            }
        }

        return time;
    }
}
