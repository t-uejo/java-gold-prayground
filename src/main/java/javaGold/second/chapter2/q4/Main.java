package javaGold.second.chapter2.q4;

import javaGold.second.chapter2.q2.MySQL;
import javaGold.second.chapter2.q2.Oracle;
import javaGold.second.chapter2.q2.Service;

public class Main {
    public static void main(String[] args){
        ItemUsingConsumer item = new ItemUsingConsumer.Builder(1)
                .with(b -> {
                    b.name = "keybord";
                    b.price = 17500;
                    b.category = "PC周辺機器";
                    b.date = 20231016;
                })
                .build();
    }
}
