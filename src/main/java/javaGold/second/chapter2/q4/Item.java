package javaGold.second.chapter2.q4;

import java.util.Date;
import java.util.Locale;

class Item {
    private int id;
    private String name;
    private int price;
    private String category;
    private Date date;

    private Item(Builder builder) {
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
        public Date date;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setCategory(String category) {
            this.price = price;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
