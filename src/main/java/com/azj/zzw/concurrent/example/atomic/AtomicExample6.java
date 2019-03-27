package com.azj.zzw.concurrent.example.atomic;

import com.azj.zzw.concurrent.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@ThreadSafe
public class AtomicExample6 {

    // client请求总数
    public static int clientTotal = 5000;

    // 允许并发的请求数
    public static int threadTotal = 200;

    public static AtomicBoolean isHappen = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 定义信号量 允许并发的数目
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 定义计数器
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    // 获取线程
                    semaphore.acquire();
                    test();
                    // 释放线程
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception---{}---{}", e.getMessage(), e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("isHappen:{}", isHappen.get());
    }

    public static void test() {
        if (isHappen.compareAndSet(false, true)) {
            log.info("execute");
        }
    }
}

