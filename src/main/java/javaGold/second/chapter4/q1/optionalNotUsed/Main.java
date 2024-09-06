package javaGold.second.chapter4.q1.optionalNotUsed;

import java.lang.module.FindException;

public class Main {
    public static void main (String[] args) {
        String[] array = new String[]{"A", "B", null};

        try {
            String result = getFromArray(array, 3);

            if(result == null){
                System.out.println("Nullです。");
            }
            System.out.println(result);

        } catch (IllegalArgumentException e) {
            System.out.println("exception");
        }
    }

    public static <T> T getFromArray(T[] array, int index) {
        if (array == null) {
            throw new IllegalArgumentException("arrayがNullです。");
        }
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("インデックス番号が正しくありません。");
        }
    }
}
