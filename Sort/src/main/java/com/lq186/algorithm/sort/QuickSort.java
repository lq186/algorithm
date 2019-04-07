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
    FileName: QuickSort.java
    Date: 2019/4/7
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 快速排序
 * 1. 定义一个分界值，将数组分为两部分
 * 2. 将大于分界值的数据集中在数组右边，小于分界值的集中在数组左边
 * 3. 左边和右边的数据独立排序，重复 2
 */
public final class QuickSort implements ISort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(final int[] array, final int left, final int right) {
        int splitValue = array[(left + right) / 2];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (array[leftIndex] < splitValue) {
                ++leftIndex;
            }
            while (array[rightIndex] > splitValue) {
                --rightIndex;
            }
            if (leftIndex < rightIndex) {
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
                --rightIndex;
                ++leftIndex;
            }
        }
        PrintUtils.printArray(array);
        if (leftIndex == rightIndex) {
            // 如果最后一个元素比基准值大，则归为右边，否则归为左边
            if (array[leftIndex] > splitValue) {
                --rightIndex;
            } else {
                ++leftIndex;
            }
        }
        if (left < rightIndex) {
            System.out.printf("left = %d, right = %d \n", left, leftIndex - 1);
            sort(array, left, leftIndex - 1);
        }
        if (leftIndex < right) {
            System.out.printf("left = %d, right = %d \n", rightIndex + 1, right);
            sort(array, rightIndex + 1, right);
        }
    }
}
