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
    FileName: BinarySearch.java
    Date: 2019/4/10
    Author: lq
*/
package com.lq186.algorithm.search;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 折半查找
 * 适用于有序数组
 */
public final class BinarySearch implements ISearch {

    @Override
    public int search(String[] array, String searchKey) {
        if (null == searchKey) {
            return -1;
        }
        mergeSort(array);
        System.out.println(">> 排序后数据 >>");
        PrintUtils.printArray(array, array.length);
        int low = 0;
        int height = array.length - 1;
        int mid;
        while (low <= height) {
            mid = (low + height) / 2;
            if (searchKey.equals(array[mid])) {
                return mid;
            } else if (searchKey.compareTo(array[mid]) < 0) {
                height = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private void mergeSort(String[] array) {
        final int arrayLength = array.length;
        final String[] arrayB = new String[array.length];
        int seqLength = 1;
        boolean mergeFlag = false;
        while (seqLength < arrayLength) {
            if (mergeFlag) {
                merge(arrayB, array, seqLength);
            } else {
                merge(array, arrayB, seqLength);
            }
            mergeFlag = !mergeFlag;
            seqLength = 2 * seqLength;
        }
    }

    private void merge(String[] arrayA, String[] arrayB, final int seqLength) {

        final int arrayLength = arrayA.length;

        int index = 0;
        while (index + seqLength < arrayLength) {

            int leftSeqIndex = index;

            int rightSeqEndIndex = index + 2 * seqLength - 1;
            if (rightSeqEndIndex >= arrayLength) {
                rightSeqEndIndex = arrayLength - 1;
            }

            int rightSeqIndex = leftSeqIndex + seqLength;
            int leftSeqEndIndex = rightSeqIndex - 1;
            int mergeArrayIndex = leftSeqIndex;
            while (leftSeqIndex <= leftSeqEndIndex && rightSeqIndex <= rightSeqEndIndex) {
                if (arrayA[leftSeqIndex].compareTo(arrayA[rightSeqIndex]) < 0) {
                    arrayB[mergeArrayIndex++] = arrayA[leftSeqIndex++];
                } else {
                    arrayB[mergeArrayIndex++] = arrayA[rightSeqIndex++];
                }
            }
            while (leftSeqIndex <= leftSeqEndIndex) {
                arrayB[mergeArrayIndex++] = arrayA[leftSeqIndex++];
            }
            while (rightSeqIndex <= rightSeqEndIndex) {
                arrayB[mergeArrayIndex++] = arrayA[rightSeqIndex++];
            }

            index = rightSeqEndIndex + 1;
        }

        for (; index < arrayLength; ++index) {
            arrayB[index] = arrayA[index];
        }

    }
}
