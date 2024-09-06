package javaGold.second.chapter2.q4;

import java.util.Date;
import java.util.function.Consumer;

class ItemUsingConsumer {
    private int id;
    private String name;
    private int price;
    private String category;
    private int date;

    private ItemUsingConsumer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category; //追加
        this.date = builder.date; //追加
    }

    public static class Builder {
        private int id;
        public String name;
        public int price;
        public String category;
        public int date;

        public Builder(int id) {
            this.id = id;
        }

        public Builder with(Consumer<Builder> itemConsumer) {
            itemConsumer.accept(this); //Builderのインスタンス自身への参照
            return this;
        }

        public ItemUsingConsumer build() {
            return new ItemUsingConsumer(this);
        }
    }
}
