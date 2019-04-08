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

import com.lq186.algorithm.util.PrintUtils;
import com.lq186.algorithm.util.RandomUtils;

public final class Bootstrap {

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [冒泡排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new BubbleSort());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [冒泡排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [选择排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new SelectionSort());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [选择排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [插入排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new InsertionSort());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [插入排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new ShellSort());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序, length = 9] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new ShellSort(), 9);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [Shell排序, length = 9] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [快速排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new QuickSort());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [快速排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        //new QuickSort().sort(new int[]{457, 552, 754, 715, 361, 524, 122, 47, 497, 978});

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [堆排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new HeapSort());
        //new HeapSort().sort(new int[]{719, 793, 302, 319, 520, 327, 949, 104, 126, 557});
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [堆排序] >>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [合并排序] >>>>>>>>>>>>>>>>>>>>>>>>");
        sort(new MergeSort(), 15);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> [合并排序] >>>>>>>>>>>>>>>>>>>>>>>>");
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

}
