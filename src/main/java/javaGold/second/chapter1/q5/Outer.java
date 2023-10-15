package javaGold.second.chapter1.q5;

public class Outer {
    void test() {
        Inner.message = "Hello";
    }
    class Inner{
        private static String message;
        public void test() {
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
        outer.new Inner().test();
    }
}
