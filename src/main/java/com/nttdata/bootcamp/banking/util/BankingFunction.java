package com.nttdata.bootcamp.banking.util;

@FunctionalInterface
public interface BankingFunction<T,U,V,R>{
    R Appply(T t,U u,V v);
}

