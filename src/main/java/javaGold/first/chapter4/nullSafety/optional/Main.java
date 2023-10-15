package javaGold.first.chapter4.nullSafety.optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // nullを持つ可能性のある値を扱う場合の例

        // 例1: 値が存在する場合
        String nonNullValue = "Hello, Optional!";
        Optional<String> optionalValue1 = Optional.of(nonNullValue);

        // 値が存在するかどうかをチェックし、値を取得
            if(optionalValue1.isPresent()) {
            String result = optionalValue1.get();
            System.out.println(result); // "Hello, Optional!"
        }

        // 例2: 値がnullの場合
        String nullableValue = null;
        Optional<String> optionalValue2 = Optional.ofNullable(nullableValue);

        // 値が存在するかどうかをチェックし、値を取得
            if (optionalValue2.isPresent()) {
            String result = optionalValue2.get(); // このブロックは実行されない
            System.out.println(result);
        } else {
            System.out.println("値は存在しません"); // "値は存在しません" が表示される
        }

        // 値が存在しない場合の代替値を指定する
        String resultOrDefault = optionalValue2.orElse("デフォルト値");
            System.out.println(resultOrDefault); // "デフォルト値" が表示される

        // 値が存在しない場合のカスタム処理を指定する
            optionalValue2.ifPresent(value -> {
            // このブロックは実行されない
            System.out.println("値が存在します: " + value);
        });
    }
}
