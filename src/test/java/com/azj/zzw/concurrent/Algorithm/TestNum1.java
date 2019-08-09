package com.azj.zzw.concurrent.Algorithm;

import org.junit.Test;

import java.util.*;

public class TestNum1 {

    /**
     * 移除迭代器   不要移除数组的资源
     */

    @Test
    public void testNum(){
        Integer[] arr = {1,2,3,4,1,2,4};
        Vector<Integer>  vector = new Vector<>(Arrays.asList(arr));
        Iterator<Integer> iterator = vector.iterator();
        Set<Integer> set = new HashSet<>();
        while (iterator.hasNext()){
            /*if (set.add(iterator.next())){
                iterator.remove();
            }*/
            if (iterator.next().equals(3)){
                iterator.remove();
            }
        }
        set.removeAll(vector);
        System.out.println(set);
    }
}
