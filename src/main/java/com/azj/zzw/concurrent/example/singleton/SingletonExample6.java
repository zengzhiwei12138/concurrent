package com.azj.zzw.concurrent.example.singleton;


import com.azj.zzw.concurrent.annotations.ThreadSafe;

/**
 * 饿汉式
 *
 * 单例实例在类装载的过程中进行创建
 */

@ThreadSafe
public class SingletonExample6 {

    // 私有化构造函数
    private SingletonExample6(){

    }

    // 提供一个单例对象
    private static SingletonExample6 singletonExample2;

    static {
        singletonExample2 = new SingletonExample6();
    }

    // 提供对外访问的方法
    public static SingletonExample6 getInstance(){
        return singletonExample2;
    }


}
