package javaGold.second.chapter1.q2;

public class Main {
    public static void main(String[] args){
        //TODO:Enumを使うこと
        IRepository oracle = Factory.getStrategy("oracle");
        oracle.getRecord();

        //以下はIRepositoryに定義されていないため呼び出すことができない。
        // Factory経由でのみoracleを参照することができる。これはリスコフの置換原則に違反することがないため堅牢な仕組みであると言える。
//        oracle.getRecord2();
    }
}
