package javaGold.first.chapter4.q1;

import java.util.Optional;

//Optionalによるリファクタリング後
public class NewTest {
    //Optionalで扱えば例外のハンドリングが必要なくなる
    //NullPointExceptionは非検査なので、例外のハンドリングが必要だが、それらが発生するリスクをなくすことができた。
    public static void main(String[] args) {
        Optional<String> result = getFromArray(new String[]{"A", "B", null}, 3);
        //isEmptyなのでifPresentOrElseに置き換えることを考えたが逆に可読性は悪くなるので辞める
        if (result.isEmpty()) {
            System.out.println("empty");
        }
    }

    //ここのstaticのTはなぜ必要なのか？
    private static <T> Optional<T> getFromArray(T[] array, int index) {
        if (array == null) {
            return Optional.empty();
        }
        try {
            //Optionalを使ってラップする
            return Optional.ofNullable(array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            //上記で例外が発生する場合がある
            return Optional.empty();
        }
    }
}
