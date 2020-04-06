/*    
    Copyright ©2019 lq186.com 
 
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
 
        http://www.apache.org/licenses/LICENSE-2.0
 
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
/*
    FileName: Bootstrap.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.List;
import com.lq186.algorithm.util.PrintUtils;
import com.lq186.algorithm.util.RandomUtils;

import java.math.BigInteger;
import java.util.ArrayList;


public final class Bootstrap {

    public static void main(String[] args) {
        build(1);
        System.out.println("--");
        build(2);
        System.out.println("--");
        build(3);
        System.out.println("--");
        build(4);
        System.out.println("--");
        build(5);
        System.out.println("--");
        build(6);
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [冒泡排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new BubbleSort());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [冒泡排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [选择排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new SelectionSort());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [选择排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [插入排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new InsertionSort());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [插入排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new ShellSort());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序, length = 9] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new ShellSort(), 9);
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序, length = 9] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [快速排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new QuickSort());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [快速排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        //new QuickSort().sort(new int[]{457, 552, 754, 715, 361, 524, 122, 47, 497, 978});
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [堆排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new HeapSort());
//        //new HeapSort().sort(new int[]{719, 793, 302, 319, 520, 327, 949, 104, 126, 557});
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [堆排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [合并排序] >>>>>>>>>>>>>>>>>>>>>>>>");
//        sort(new MergeSort(), 15);
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [合并排序] >>>>>>>>>>>>>>>>>>>>>>>>");
    }

    private static final void sort(final ISort sort) {
        sort(sort, 10);
    }

    private static final void sort(final ISort sort, final int arrayLength) {
        final int[] array = RandomUtils.randomIntArray(arrayLength);
        System.out.println(">> 原始数组 >>");
        PrintUtils.printArray(array);
        sort.sort(array);
        System.out.println(">> 排序后数组 >>");
        PrintUtils.printArray(array);
    }

    // ()  2^n - n + 1
    // ()() (())
    // ()()() ()(()) (()()) ((()))
    private static void build(int n) {
        java.util.List<String> list = new ArrayList<>();
        String temp;
        StringBuffer buffer = new StringBuffer();
        BigInteger count = new BigInteger("2").pow(2 * n - 1);
        BigInteger step = new BigInteger("2");
        BigInteger start = new BigInteger("2").pow(n).subtract(BigInteger.ONE);
        for (BigInteger i = start; i.compareTo(count) < 0; i = i.add(step)) {
            if (i.bitCount() == n) {
                buffer.setLength(0);
                temp = i.toString(2);
                for (int j = temp.length(); j < 2 * n; ++j) {
                    buffer.append("0");
                }
                buffer.append(temp);

                char[] chars = buffer.toString().toCharArray();
                int leftCount = 0;
                for (int j = 0; j < chars.length; ++j) {
                    if ('0' == chars[j]) {
                        leftCount++;
                    } else {
                        leftCount--;
                    }
                    if (leftCount < 0) {
                        break;
                    }
                }
                if (leftCount == 0) {
                    System.out.println(Long.valueOf(buffer.toString(), 2));
                }
            }
        }
        /*list.forEach(str -> {
            char[] chars = str.toCharArray();
            int leftCount = 0;
            for (int i = 0; i < chars.length; ++i) {
                if ('0' == chars[i]) {
                    leftCount++;
                } else {
                    leftCount--;
                }
                if (leftCount < 0) {
                    break;
                }
            }
            if (leftCount == 0) {
                System.out.println(Long.valueOf(str, 2));
            }
        });*/
    }

    private static void build2(int n) {
        java.util.List<String> list = new ArrayList<>();
        String temp;
        StringBuffer buffer = new StringBuffer();
        BigInteger count = new BigInteger("2").pow(2 * n);
        for (BigInteger i = BigInteger.ZERO; i.compareTo(count) < 0; i.add(BigInteger.ONE)) {
            buffer.setLength(0);
            temp = i.toString(2);
            for (int j = temp.length(); j < 2 * n; ++j) {
                buffer.append("0");
            }
            buffer.append(temp);
            list.add(buffer.toString());
        }
        list.forEach(str -> {
            char[] chars = str.toCharArray();
            int leftCount = 0;
            for (int i = 0; i < chars.length; ++i) {
                if ('0' == chars[i]) {
                    leftCount++;
                } else {
                    leftCount--;
                }
                if (leftCount < 0) {
                    break;
                }
            }
            if (leftCount == 0) {
                System.out.println(str.replace("0", "(").replace("1", ")"));
            }
        });
    }

}
