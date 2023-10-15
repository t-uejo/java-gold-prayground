package javaGold.first.chapter4.nullSafety.optionMonad;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //ifPresentの実装
        // 値が存在する場合
        Optional<String> nonNullValue = Optional.of("Hello, Option!");
        nonNullValue.ifPresent(value -> System.out.println(value)); // "Hello, Option!" が表示される

        // 値が存在しない場合
        Optional<String> nullValue = Optional.ofNullable(null);
        nullValue.ifPresent(value -> System.out.println(value)); // 何も表示されない

        //ifPresentOrElseの実装
        present().ifPresentOrElse(
                s -> System.out.println(s),
                () -> System.out.println("not present")
        );
        notPresent().ifPresentOrElse(
                s -> System.out.println(s),
                () -> System.out.println("not present")
        );

        
    }

    private static Optional<String> present() {
        return Optional.of("present");
    }

    private static Optional<String> notPresent() {
        return Optional.empty();
    }
}
