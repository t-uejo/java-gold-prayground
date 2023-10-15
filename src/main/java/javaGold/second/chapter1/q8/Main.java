package javaGold.second.chapter1.q8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //ArrayListをインスタンス化して参照をlist2に渡している。
        List<String> listA = new ArrayList<>();
        listA.add("A");
        listA.add("B");
        listA.add("C");

        //ArrayListを継承したサブクラスを匿名クラスとして定義してインスタンス化し、
        //初期ブロックでsuperクラスであるArrayListのaddメソッドを呼び出してコレクションに追加している。
        List<String> listB = new ArrayList<String>() {
            {
                super.add("A");
                super.add("B");
                super.add("C");
            }
        };

        //上記コレクションを使う上で何らかの違いはあるのか？
    }
}
