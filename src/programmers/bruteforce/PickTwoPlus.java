package programmers.bruteforce;

import java.util.*;

public class PickTwoPlus {

    public int[] pickTwoPlus(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<numbers.length;i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);


//        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        PickTwoPlus sol = new PickTwoPlus();
        sol.pickTwoPlus(new int[]{2,1,3,4,1});
    }
}
