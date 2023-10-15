package javaGold.second.chapter1.q4;

public class Outer {
    private String message = "Hello, Java";
    static class Inner{
        public void test() {
            //以下でコンパイルエラーとなる
//            System.out.println(message);
        }
    }
}
