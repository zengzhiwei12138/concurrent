package com.azj.zzw.concurrent.example.singleton;

import com.azj.zzw.concurrent.annotations.UnThreadSafe;

/**
 * 懒汉式单例模式
 */

@UnThreadSafe
public class SingletonExample1 {

    // 私有化构造函数
    private SingletonExample1(){

    }

    // 提供一个单例对象
    private static SingletonExample1 singletonExample1 = null;

    // 提供对外访问的方法
    public static SingletonExample1 getInstance(){
        if (singletonExample1 == null){
            singletonExample1 = new SingletonExample1();
        }
        return singletonExample1;
    }


}
