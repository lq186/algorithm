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
    FileName: BubbleSort.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 冒泡排序
 * 1. 比较相邻的两个数据的大小，如果前面的数据大于后面的数据，交换两个数据。经过一轮排序后，最大的数据可以排好
 * 2. 重复 1 {n - 1}次
 */
public final class BubbleSort implements ISort {

    public final void sort(int[] array) {
        int temp;

        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < array.length - i; ++j) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.printf(">> array[%d]和array[%d]互换 >>\n", j, j + 1);
                    PrintUtils.printArray(array);
                }
            }
            System.out.printf(">> 第[ %d ] 步排序结果 >>\n", i);
            PrintUtils.printArray(array);
        }
    }

}
