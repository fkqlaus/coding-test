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

// 인덱스 접근
arr[i][0]        // i번째 행의 첫 번째 값
arr.length       // 행 개수
arr[i].length    // 열 개수 (i번째 행의 길이)
```

### 모든 조합 순회 패턴 (중복 없는 두 수 뽑기)
```java
for (int i = 0; i < arr.length; i++) {
    for (int j = i + 1; j < arr.length; j++) {
        // i, j 항상 다른 인덱스
        // j = i + 1 이 핵심 → 중복 조합 없음
    }
}
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

// 2차원 배열에서 열별 최댓값
int maxWidth = 0;
int maxHeight = 0;
for (int i = 0; i < arr.length; i++) {
    maxWidth  = Math.max(maxWidth,  arr[i][0]);
    maxHeight = Math.max(maxHeight, arr[i][1]);
}
```

### 두 값 정렬 (swap)
```java
// 가로가 세로보다 작으면 swap → 방향 통일
if (sizes[i][0] < sizes[i][1]) {
    int temp = sizes[i][0];
    sizes[i][0] = sizes[i][1];
    sizes[i][1] = temp;
}

// 또는 Math.max/min으로 깔끔하게
int width  = Math.max(sizes[i][0], sizes[i][1]);
int height = Math.min(sizes[i][0], sizes[i][1]);
```

### 중복 제거 → Set
```java
Set<Integer> set = new HashSet<>();
set.add(값);  // 중복 자동 제거
```

### Set → 정렬 → int[] 변환
```java
Set<Integer> set = new HashSet<>();

List<Integer> list = new ArrayList<>(set);
Collections.sort(list);  // 오름차순

return list.stream().mapToInt(Integer::intValue).toArray();
```

### 가변 결과 → List → int[] 변환
```java
List<Integer> list = new ArrayList<>();
list.add(1);

return list.stream().mapToInt(Integer::intValue).toArray();
```

---

## 풀이 목록

| 문제 | 플랫폼 | 난이도 | 핵심 포인트 |
|------|--------|--------|------------|
| 모의고사 | 프로그래머스 | Lv.1 | % 패턴 반복, 2차원 배열 |
| 두 개 뽑아서 더하기 | 프로그래머스 | Lv.1 | 조합 순회 (j = i+1), HashSet 중복제거 |
| 최소직사각형 | 프로그래머스 | Lv.1 | swap으로 방향 통일, 2차원 배열 열별 최댓값 |

---

## 공통 주의사항
- `import java.util.*;` 항상 상단에 선언
- 최솟값 구할 때 초기값 `Integer.MAX_VALUE` 로 설정
- 크기 모를 때 배열 대신 List 사용
- 열 길이는 `arr.length` 아니라 `arr[i].length` 로 접근
- 조합 순회할 때 `j = i + 1` 빠뜨리면 중복 조합 발생
- 결과 정렬 필요하면 Set → List 변환 후 `Collections.sort()`