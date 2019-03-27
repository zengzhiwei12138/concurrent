package com.azj.zzw.concurrent;

import com.azj.zzw.concurrent.annotations.UnThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@UnThreadSafe
public class ConcurrentTest {

    // client请求总数
    public static int clientTotal = 5000;

    // 允许并发的请求数
    public static int threadTotal = 200;

    // 计数的值
    public static int count = 0;

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
                    add();
                    // 释放线程
                    semaphore.release();
                } catch (Exception e){
                    log.error("exception---{}---{}",e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("count:{}",count);
    }

    private static void add() {
        count++;
    }
}

