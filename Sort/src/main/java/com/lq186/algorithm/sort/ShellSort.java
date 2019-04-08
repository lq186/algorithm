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
    FileName: ShellSort.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * Shell 排序(不稳定排序)
 * 1. 将有 length 个元素的数组分成 length / 2 个数字序列，第 1 个数据 和 第 length / 2 + 1 个数据为一对, 依次类推
 * 2. 一次循环使每一个序列对排好顺序
 * 3. 再次变为 length / 4 个序列，再次排序
 * 4. 重复 3 , 直到变为一个序列
 * <p>
 * 平均复杂度 O(n^(3/2)), 最坏复杂度 O(n^2)
 */
public final class ShellSort implements ISort {

    public final void sort(int[] array) {
        final int length = array.length;
        int step = 0;
        for (int n = length / 2; n >= 1; n = n / 2) {
            for (int i = n; i < length; ++i) {
                int temp = array[i];
                int index = i - n;
                while (index >= 0 && temp < array[index]) {
                    array[index + n] = array[index];
                    index = index - n;
                }
                array[index + n] = temp;
            }
            System.out.printf(">> 第[ %d ]步的排序结果 >> ", ++step);
            PrintUtils.printArray(array);
        }
    }

}
