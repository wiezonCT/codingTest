package lab.wy.programmers.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 *
 *
 * [오름차순 VS 내림차순 => 시간 차이가 발생하는 핵심적인 이유]
 *
 * 1.Boxing/Unboxing 오버헤드: desc_Solution의 가장 큰 성능 저하 요인입니다.
 *      •Arrays.stream(peoples).boxed()... 부분은 int 타입의 각 원소를 Integer 객체로 변환(Boxing)하는 과정을 거칩니다.
 *      •단순한 숫자 값을 객체로 포장하는 이 과정은 생각보다 많은 비용이 듭니다. N개의 객체를 새로 생성하고 메모리를 할당해야 하기 때문입니다.
 *
 * 2.메모리 접근 방식의 차이:
 *      •int[]는 데이터가 메모리의 연속된 공간에 저장됩니다. CPU가 캐시를 활용하여 매우 빠르게 데이터에 접근할 수 있습니다 (메모리 지역성).
 *      •Integer[]는 객체에 대한 **참조(주소값)**를 연속된 공간에 저장합니다. 실제 Integer 객체들은 힙(heap) 메모리 여기저기에 흩어져 있을 수 있습니다. CPU가 데이터를 읽기 위해 여러 메모리 주소를 건너뛰어야 하므로 캐시 효율이 떨어지고 속도가 느려집니다.
 *
 * 3.정렬 알고리즘의 최적화:
 *      •Arrays.sort(int[])는 기본형(primitive type)에 맞춰 매우 효율적으로 구현된 듀얼 피봇 퀵 정렬(Dual-Pivot Quicksort)을 사용합니다.
 *      •Arrays.sort(Object[], Comparator)는 객체 정렬에 사용되며, 일반적으로 팀 정렬(Timsort)을 사용합니다. 이것도 매우 효율적이지만, Comparator 호출 및 객체 참조에 따른 간접적인 비용 때문에 기본형 정렬보다는 느립니다.
 */
public class Boat {



    @Test
    public void test(){
        Assertions.assertEquals(Solution(new int[]{70, 50, 80, 50}, 100), 3);
        Assertions.assertEquals(Solution(new int[]{70, 80, 50}, 100), 3);
        Assertions.assertEquals(desc_Solution(new int[]{70, 50, 80, 50}, 100), 3);
        Assertions.assertEquals(desc_Solution(new int[]{70, 80, 50}, 100), 3);

    }

    private int Solution(int[] peoples, int limit){

        Arrays.sort(peoples);

        //투포인터 사용
        int startPoint = 0;
        int endPoint = peoples.length - 1;
        int count = 0;
        while(startPoint <= endPoint){
            if(peoples[startPoint] + peoples[endPoint] <= limit){
                startPoint++;
            }

            endPoint--;
            count++;
        }

        return count;

    }

    private int desc_Solution(int[] peoples, int limit){
        Integer[] IntegerPeoples = Arrays.stream(peoples).boxed().toArray(value -> {
            return new Integer[value];
        });

        Arrays.sort(IntegerPeoples, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        int count = 0;
        int left = 0;
        int right = IntegerPeoples.length - 1;

        while(left <= right){
            if(IntegerPeoples[left] + IntegerPeoples[right] <= limit){
                right--;
            }

            left++;
            count++;
        }

        return count;
    }

    private int fail_Solution(int[] peoples, int limit) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < peoples.length; i++){
            list.add(peoples[i]);
        }


        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int count = 0;
        List<Integer> removeList = new ArrayList<>();

        // 2명만 태울 수 있다는 점이 고려되지 않음
        while(!list.isEmpty()){
            int calcLimit = limit;

            for (Integer current : list) {
                if(calcLimit >= current){
                    calcLimit -= current;
                    removeList.add(current);
                }
            }

            // 지우는 로직은 O(N)이 되는 구조 (배열 전체를 순회해야하기 때문에 - 비효율)
            for (Integer remove : removeList) {
                list.remove(remove);
            }

            count++;
        }


        return count;
    }
}
