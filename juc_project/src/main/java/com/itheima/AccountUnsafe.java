package com.itheima;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountUnsafe implements AccountOne{

    private AtomicInteger balance;
    public AccountUnsafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }
    @Override
    public void withdraw(Integer amount) {
        while (true) {
            int prev = balance.get();
            int next = prev - amount;
            if (balance.compareAndSet(prev, next)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        AccountOne.demo(new AccountUnsafe(10000));
    }
}
