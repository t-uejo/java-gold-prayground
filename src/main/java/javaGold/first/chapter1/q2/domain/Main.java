package javaGold.first.chapter1.q2.domain;

import javaGold.first.chapter1.q2.repository.IRepository;

public class Main {
    public static void main(String[] args){
        //MainからはIRepositoryを使うしかない。
        //坂本さんがMediatorパターンを使っていたのもこの原理となる。要は画面側とバッチ側で公開を分けることができるので保守性がかなり高い。
        IRepository repository = IRepository.factory();
        repository.getRecord();
    }
}
