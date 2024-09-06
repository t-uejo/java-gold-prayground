package javaGold.second.chapter2.q2;

public class Main {
    public static void main(String[] args){
        Service service = new Service();

        //Oracleにインサートする
        service.insert(() -> new Oracle());

        //MySQLにインサートする
        service.insert(() -> new MySQL());
    }
}
