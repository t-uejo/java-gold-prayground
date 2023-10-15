package javaGold.first.chapter1.q8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //パターン1
        List<String> list = new ArrayList<String>() {
            {
                super.add("A");
                super.add("B");
                super.add("C");
            }
        };

        //いつものパターン
        List<String> list2 = new ArrayList<String>();
        list2.add("A");
        list2.add("B");
        list2.add("C");
    }
}
