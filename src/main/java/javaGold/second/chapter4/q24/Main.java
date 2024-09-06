package javaGold.second.chapter4.q24;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main (String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,1,1,1);

        Map<Integer,List<Integer>> map =
                nums.stream()
                    .collect(Collectors.groupingBy(i -> i)); //マップのキーとなるのがこのラムダ式が返す型。バリューが

        System.out.println(map);
        //=> {1=[1, 1, 1, 1], 2=[2], 3=[3], 4=[4], 5=[5], 6=[6], 7=[7], 8=[8], 9=[9]}
    }
}
