package programmers.bruteforce;

public class MinOblong {

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/86491
    1. 그냥 큰 놈은 다 가로로 돌려버려
    2. 그 중에서 제일 큰 거 고르면
    3. 값 나온다
     */
    public int solution(int[][] sizes) {
        int answer = 0;

        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        int width = 0;
        int height = 0;

        for(int i=0; i<sizes.length; i++) {
            width = Math.max(width,sizes[i][0]);
            height = Math.max(height,sizes[i][1]);
        }

        answer = width * height;
        return answer;
    }

}
