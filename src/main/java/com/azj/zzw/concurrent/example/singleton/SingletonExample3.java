package com.azj.zzw.concurrent.example.singleton;

import com.azj.zzw.concurrent.annotations.ThreadSafe;

/**
 * 懒汉式单例模式
 */

@ThreadSafe
public class SingletonExample3 {

    // 私有化构造函数
    private SingletonExample3(){

    }

    // 提供一个单例对象
    private static SingletonExample3 singletonExample1 = null;

    // 提供对外访问的方法  synchronized 同一时间只允许一个线程访问
    public synchronized static SingletonExample3 getInstance(){
        if (singletonExample1 == null){
            singletonExample1 = new SingletonExample3();
        }
        return singletonExample1;
    }


}
