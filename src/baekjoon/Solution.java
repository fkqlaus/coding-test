package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            answer[i] = (100-progresses[i] + speeds[i] - 1)/speeds[i];
        }

        Integer temp = null;
        for(Integer i : answer) {
            if(temp == null) {
                temp = i;
            } else {
                if(temp > i){
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
