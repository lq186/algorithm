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
    FileName: InsertionSort.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 插入排序
 * 1. 对数组的前两个数据进行从小到大的排序
 * 2. 将第三个数据与排好的两个数据比较，然后插入合适的位置
 * 3. 将第四个数据插入已排好的前三个数据中
 * 4. 重复 3
 */
public final class InsertionSort implements ISort {

    public final void sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int temp = array[i];
            int index = i - 1;
            while (index >= 0 && temp < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = temp;
            System.out.printf(">> 第[ %d ]步排序结果 >> \n", i);
            PrintUtils.printArray(array);
        }
    }

}
