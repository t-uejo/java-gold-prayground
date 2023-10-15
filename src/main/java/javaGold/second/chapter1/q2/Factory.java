package javaGold.second.chapter1.q2;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static final Map<String, IRepository> strategies = new HashMap<>();

    static {
        strategies.put("oracle", new oracle());
    }

    public static IRepository getStrategy(String targetResource){
        return strategies.get(targetResource);
    }

    //Factory内に隠蔽する。privateなので外部から直接インスタンス化される恐れはない。
    //以下の実装では、staticから非staticメンバなどへの参照はできないため注意したい。
    //しかし、設計上Factoryのトップレベルクラスのメンバにアクセスすることはないと想定する。
    private static class oracle implements IRepository {
        @Override
        public int getRecord() {
            return 0;
        }

        //以下は公開したくないメソッド
        public int getRecord2() {
            return 0;
        }
    }
}
