package com.azj.zzw.concurrent.example.singleton;


import com.azj.zzw.concurrent.annotations.Recommend;
import com.azj.zzw.concurrent.annotations.ThreadSafe;

/**
 * 枚举单例模式  最安全
 * [推荐写法]
 */

@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有化构造函数
    private SingletonExample7() {

    }

    // 提供对外访问的方法
    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singletonExample7;

        // JVM保证方法只会调用一次
        Singleton() {
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singletonExample7;
        }
    }

}
