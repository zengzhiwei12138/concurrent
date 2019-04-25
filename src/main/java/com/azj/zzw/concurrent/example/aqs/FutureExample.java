package com.azj.zzw.concurrent.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 等待最帅的添加描述
 *
 * @author zzw zengzhiwei_hfut@163.com
 * @see 等待最帅的添加
 * @since 2019/4/3 0003-14:33
 */
@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        log.info("");

    }
}
