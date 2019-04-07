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
    FileName: Operations.java
    Date: 2019/4/7
    Author: lq
*/
package com.lq186.algorithm.operation;

import com.lq186.algorithm.util.PrintUtils;
import com.lq186.algorithm.util.RandomUtils;

/**
 * 异或运算符
 */
public final class Operations {

    public static void main(String[] args) {

        xORChangeInt();

        xORChangeArray(RandomUtils.randomIntArray(10));

        // 向左位移
        leftDisplacement();

        // 向右位移
        rightDisplacement();
    }

    /**
     * 异或交换两个数据
     */
    private static final void xORChangeInt() {

        // 无需变量交换两个数
        int a = 9;
        int b = 27;

        System.out.printf("异或交换前 >> a = %d, b = %d\n", a, b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.printf("异或交换后 >> a = %d, b = %d\n", a, b);
    }

    /**
     * 使用异或逆序数组
     * @param array
     */
    private static final void xORChangeArray(int[] array) {

        System.out.println("数组逆序前 >>");
        PrintUtils.printArray(array);

        for (int i = 0; i < array.length / 2; ++i) {
            array[i] = array[i] ^ array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] ^ array[array.length - 1 - i];
            array[i] = array[i] ^ array[array.length - 1 - i];
        }

        System.out.println("数组逆序后 >>");
        PrintUtils.printArray(array);
    }

    /**
     * 向左位移
     */
    private static final void leftDisplacement() {

        System.out.printf("1 * 2^5 = %d\n", 1 << 5);

        System.out.printf("2 * 2^3 = %d\n", 2 << 3);

        System.out.printf("3 * 2^2 = %d\n", 3 << 2);

    }

    private static final void rightDisplacement() {

        System.out.printf("128 / 2^5 = %d\n", 128 >> 5);

        System.out.printf("64 / 2^3 = %d\n", 64 >> 3);

        System.out.printf("32 / 2^2 = %d\n", 32 >> 2);

    }
}
