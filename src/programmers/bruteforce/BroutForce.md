# 완전탐색 (Brute Force)

## 핵심 사고방식
```
① 모든 경우를 다 확인한다
② 조건에 맞는 것만 추린다
③ 결과를 정리해서 반환한다
```
최적화보다 정확성이 먼저. 일단 다 돌려.

---

## 핵심 문법 & 패턴

### % 나머지 = 패턴 반복
패턴이 반복되는 문제는 무조건 이 공식
```java
i % 배열.length
// 인덱스가 배열 길이를 넘지 않아서 자동으로 반복됨
```

### 비슷한 데이터 → 2차원 배열로 묶기
```java
// 반복문으로 한번에 처리 가능
int[][] patterns = {
    {1, 2, 3, 4, 5},
    {2, 1, 2, 3, 2, 4, 2, 5},
    {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
};
```

### 최댓값 / 최솟값 구하기
```java
// 최댓값
int max = 0;
for (int c : count) {
    max = Math.max(max, c);
}

// 최솟값 (초기값 주의!)
int min = Integer.MAX_VALUE;
for (int c : count) {
    min = Math.min(min, c);
}
```

### 가변 결과 → List → int[] 변환
```java
List<Integer> list = new ArrayList<>();
list.add(1);

// List → int[] 변환
return list.stream().mapToInt(Integer::intValue).toArray();
```

---

## 풀이 목록

| 문제 | 플랫폼 | 난이도 | 핵심 포인트 |
|------|--------|--------|------------|
| 모의고사 | 프로그래머스 | Lv.1 | % 패턴 반복, 2차원 배열 |

---

## 공통 주의사항
- `import java.util.*;` 항상 상단에 선언
- 최솟값 구할 때 초기값 `Integer.MAX_VALUE` 로 설정
- 크기 모를 때 배열 대신 List 사용