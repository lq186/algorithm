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
    FileName: MergeSort.java
    Date: 2019/4/8
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 合并排序(稳定排序)
 * <p>
 * 平均复杂度 O(nlogn), 最坏复杂度 O(nlogn)
 */
public final class MergeSort implements ISort {

    @Override
    public void sort(int[] array) {
        final int arrayLength = array.length;
        final int[] arrayB = new int[arrayLength];
        int step = 0;
        int sequenceLength = 1; // 有序序列长度
        boolean mergeFlag = false;
        while (sequenceLength < arrayLength) {
            if (mergeFlag) { // 交替使用原数组和新数组进行合并后的数组保存
                merge(arrayB, array, arrayLength, sequenceLength);
            } else {
                merge(array, arrayB, arrayLength, sequenceLength);
            }
            mergeFlag = !mergeFlag;
            sequenceLength = sequenceLength * 2;

            System.out.printf(">> 第[ %d ]步排序結果 >>\n", ++step);
            PrintUtils.printArray(mergeFlag ? array : arrayB);
        }
    }

    private void merge(final int[] arrayA, final int[] arrayB, final int arrayLength, final int sequenceLength) {
        int index = 0;
        while (index + sequenceLength < arrayLength) {
            int rightSeqEndIndex = index + 2 * sequenceLength - 1; // 最后一个序列的最后一个元素位置
            if (rightSeqEndIndex >= arrayLength) {
                rightSeqEndIndex = arrayLength - 1; // 如果序列长度小于序列长度，则最后一个元素的位置标为最后一个
            }
            final int leftSeqEndIndex = index + sequenceLength - 1;

            int mergeArrayIndex = index;
            int leftSeqIndex = index;
            int rightSeqIndex = index + sequenceLength;
            // 有序的把两个合并的数组拷贝到新的数组中
            while (leftSeqIndex <= leftSeqEndIndex && rightSeqIndex <= rightSeqEndIndex) {
                if (arrayA[leftSeqIndex] <= arrayA[rightSeqIndex]) {
                    arrayB[mergeArrayIndex++] = arrayA[leftSeqIndex++];
                } else {
                    arrayB[mergeArrayIndex++] = arrayA[rightSeqIndex++];
                }
            }
            // 如果右边数组已经合并完，那么复制左边的剩余数据
            while (leftSeqIndex <= leftSeqEndIndex) {
                arrayB[mergeArrayIndex++] = arrayA[leftSeqIndex++];
            }
            // 如果左边数组已经合并完，那么复制右边的剩余数据
            while (rightSeqIndex <= rightSeqEndIndex) {
                arrayB[mergeArrayIndex++] = arrayA[rightSeqIndex++];
            }
            // 合并下一个序列
            index = rightSeqEndIndex + 1;
        }

        // 复制最后一个序列，如果有的话
        for (; index < arrayLength; ++index) {
            arrayB[index] = arrayA[index];
        }
    }
}
