package com.azj.zzw.concurrent.example.lock;

import javax.xml.crypto.Data;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock的写锁和读锁的学习
 *
 * @author zzw zengzhiwei_hfut@163.com
 * @see ReentrantReadWriteLock
 * @since 2019/4/3 0003-14:14
 */
public class LockExample1 {

    private Map<String, Data> map = new TreeMap<>();

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // 读锁
    private final Lock readLock = lock.readLock();

    // 写锁
    private final Lock writeLock = lock.writeLock();

    public Data get(String key) {
        readLock.lock();
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void set(String key, Data value) {
        writeLock.lock();
        try {
            map.put(key,value);
        }finally {
            readLock.unlock();
        }
    }


}
