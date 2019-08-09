package com.azj.zzw.concurrent.Algorithm;

/**
 * 直接插入排序
 */

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        testInsertSort(arr);
        // 不要在循环里面拼 + 号   因为一个 + 号代码 new StringBuilder().append();
        StringBuilder sb = new StringBuilder(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append("->");
        }
        System.out.println(sb.toString());
    }

    private static void testInsertSort(int[] arr) {
        // 直接插入排序的原理
        // 从第二个数开始到最后一个   依次和前面所有的数进行对比  如果前面的数比对比的数大  则大数后移动复制一位  然后继续往前比较
        for (int i = 1; i < arr.length; i++) {
            // 取出对比的数  从第二位开始
            int temp = arr[i];
            // 一 一往前对比
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) { // 不断往前对比  直到第一位
                // 如果对比的数 比标本大  则对比的数后移动一位  不是互换!!
                arr[j+1] = arr[j];
            }
            // 循环之和 j 多减小了一位 把最后不再移动的位置赋值为temp
            arr[j+1] = temp;
        }
    }
}
