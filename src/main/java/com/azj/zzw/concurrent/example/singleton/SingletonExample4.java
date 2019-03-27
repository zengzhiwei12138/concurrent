package com.azj.zzw.concurrent.example.singleton;

import com.azj.zzw.concurrent.annotations.ThreadSafe;

/**
 * 懒汉式单例模式
 * 双重同步锁单例模式
 *  volatile的两种使用场景:
 *  1) 状态修改; boolean
 *  2) 双重检测; 禁止指令重排
 *
 *  如果去掉volatile则会线程不安全
 */

@ThreadSafe
public class SingletonExample4 {

    // 私有化构造函数
    private SingletonExample4(){

    }

    // 提供一个单例对象  volatile限制JVM和CPU对分配对象的过程进行指令重排
    private volatile static SingletonExample4 singletonExample1 = null;

    // 提供对外访问的方法  synchronized 同一时间只允许一个线程访问
    public static SingletonExample4 getInstance(){
        if (singletonExample1 == null){
            synchronized (SingletonExample4.class){ // 同步锁
                if (singletonExample1 == null){ // 双重检测机制
                    singletonExample1 = new SingletonExample4();
                    // 1. memory = allocate()   分配对象内存空间
                    // 2. ctorInstance() 初始化对象
                    // 3. instance = memory 将singletonExample1指向刚分配的内存
                    // 多线程的情况下  JVM和CPU优化   发生了指令重排
                    // 1->3->2
                    // 1. memory = allocate()   分配对象内存空间
                    // 3. instance = memory 将singletonExample1指向刚分配的内存
                    // 2. ctorInstance() 初始化对象
                }
            }
        }
        return singletonExample1;
    }

}
