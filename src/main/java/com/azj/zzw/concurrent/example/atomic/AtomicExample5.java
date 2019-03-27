package com.azj.zzw.concurrent.example.atomic;

import com.azj.zzw.concurrent.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"conut");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 atomicExample5 = new AtomicExample5();

    public static void main(String[] args) throws InterruptedException {
        if (fieldUpdater.compareAndSet(atomicExample5,100,120)){
            log.info("update success---{}",atomicExample5.getCount());
        }

        if (fieldUpdater.compareAndSet(atomicExample5,100,120)){
            log.info("update success 2----{}",atomicExample5.getCount());
        } else {
            log.info("update failed----{}",atomicExample5.getCount());
        }

    }

}

