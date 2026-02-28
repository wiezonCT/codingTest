# 코딩테스트 학습 가이드

이 저장소에서는 프로그래머스와 백준 등의 코딩테스트 문제를 풀이합니다. 효율적인 학습을 위해 아래 두 가지 방법 중 하나를 선택하여 진행할 수 있습니다.

## 1. Main 메서드를 활용한 실행 방식
기존 소스 코드 작성 방식과 동일하게 클래스 내에 `main` 메서드를 작성하여 실행합니다.

- **주의사항**: `Solution`이나 `Main`과 같은 너무 일반적인 클래스 명은 중복이 발생하기 쉬우므로 피해야 합니다. 문제 번호나 구체적인 문제 명을 클래스 이름으로 사용하세요.
- **예시 코드 (`G1016.java`)**:
```java
public class G1016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 처리 및 로직 구현
        System.out.println(result);
    }
}
```
- **장점**: 별도의 설정 없이 IDE의 Run 버튼으로 바로 실행 결과를 확인할 수 있습니다.

## 2. 테스트 코드를 활용한 실행 방식
`src/test/java` 경로 내에 JUnit 테스트 코드를 작성하여 실행합니다.

- **주의사항**: **패키지명과 클래스명은 반드시 영문으로 작성**해야 정상적으로 인식 및 실행됩니다. (현재 프로젝트 설정상 영문이 아닌 경우 인식이 되지 않을 수 있습니다.)
- **예시 코드 (`mock_exam.java`)**:
```java
public class mock_exam {
    @Test
    void test() {
        int[] array = {1, 2, 3, 4, 5};
        Assertions.assertEquals(List.of(1), solution(array));
    }

    private List<Integer> solution(int[] param) {
        // 로직 구현
        return resultList;
    }
}
```
- **실행 방식**: `@Test` 어노테이션을 사용하여 다양한 테스트 케이스를 검증하는 방식으로 작성합니다.
- **장점**: 여러 입력값에 대한 결과를 한 번에 검증하기 용이하며, 체계적인 코드 관리가 가능합니다.