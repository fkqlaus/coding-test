package programmers.bruteforce;

import baekjoon.Solution;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

//    https://school.programmers.co.kr/learn/courses/30/lessons/42840
//    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,
    public int[] mockExam(int[] answer) {

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] count = new int[3]; // 각 수포자 맞힌 개수

        for(int i=0; i<answer.length; i++) {
            for(int j=0; j<3; j++){
                if(answer[i] == patterns[j][i%patterns[j].length]){
                    count[j]++;
                }
            }
        }

        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i] == max) {
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        MockExam sol = new MockExam();
    }

}
