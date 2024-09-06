package javaGold.second.chapter2.q2;

import java.util.function.Supplier;

public class Service {
    public void insert(Supplier<IRepository> supplier) {
        IRepository repository = supplier.get();
        repository.insert();
    }

    public int getRecord(Supplier<IRepository> supplier) {
        IRepository repository = supplier.get();
        return repository.getRecord();
    }
}
