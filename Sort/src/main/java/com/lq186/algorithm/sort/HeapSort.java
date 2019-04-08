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
    FileName: HeapSort.java
    Date: 2019/4/7
    Author: lq
*/
package com.lq186.algorithm.sort;

import com.lq186.algorithm.util.PrintUtils;

/**
 * 堆排序(不稳定排序)
 * 构造堆(完全二叉树), 堆排序输出
 * <p>
 * 平均复杂度 O(nlogn), 最坏复杂度 O(nlogn)
 */
public final class HeapSort implements ISort {

    @Override
    public void sort(final int[] array) {
        final int length = array.length;
        // 构建大根堆
        for (int i = length / 2 - 1; i >= 0; --i) {
            final int rootNodeIndex = changeAndGetRootNodeIndex(array, i, length);
            if (rootNodeIndex >= 0) { // 堆被破坏，需要重新调整
                i = rootNodeIndex;
            }
        }
        System.out.println(">> 原数据构成的堆 >>");
        PrintUtils.printArray(array, length);

        for (int i = length - 1; i > 0; --i) {
            final int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            changeAndGetRootNodeIndex(array, 0, i);
            System.out.printf(">> 第[%d]步的排序结果 >>\n", length - i);
            PrintUtils.printArray(array, length);
        }
    }

    private int changeAndGetRootNodeIndex(final int[] array, final int rootNodeIndex, final int length) {
        int tempRightNodeIndex;
        int tempRootNodeIndex = rootNodeIndex;
        while ((tempRightNodeIndex = 2 * tempRootNodeIndex + 1) < length) { // 第 i 个结点有 右子树
            if (tempRightNodeIndex + 1 < length && array[tempRightNodeIndex] < array[tempRightNodeIndex + 1]) {
                // 右左子树小于右子树，则需要比较右子树
                tempRightNodeIndex++; // 指向右子树
            }

            if (array[tempRootNodeIndex] < array[tempRightNodeIndex]) {
                // 根小于叶子结点，则交换数据
                final int temp = array[tempRootNodeIndex];
                array[tempRootNodeIndex] = array[tempRightNodeIndex];
                array[tempRightNodeIndex] = temp;

                // 堆被破坏，需要重新调整
                tempRootNodeIndex = tempRightNodeIndex;
            } else {
                // 根节点最大，堆没有被破坏，不需要调整
                tempRootNodeIndex = -1;
                break;
            }
        }
        return tempRootNodeIndex;
    }
}
