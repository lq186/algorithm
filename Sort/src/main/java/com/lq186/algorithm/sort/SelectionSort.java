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
    FileName: SelectionSort.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 选择排序(不稳定排序)
 * 1. 从原始数据中选出一个最小的数，和第1个位置的数据进行交换；
 * 2. 从剩下 {n - 1} 个数据中选出一个最小的，和第二个位置的数据交换；
 * 3. 重复 1 和 2
 * <p>
 * 平均复杂度 O(n^2), 最坏复杂度 O(n^2)
 */
public final class SelectionSort implements ISort {

    public final void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                System.out.printf(">> array[%d] 和 array[%d] 互换 >>\n", index, i);
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            System.out.printf(">> 第[ %d ]步排序结果 >>\n", i + 1);
            PrintUtils.printArray(array);
        }
    }

}
