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
    FileName: PrintUtils.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.util;

public final class PrintUtils {

    public static final void printArray(int[] array) {
        printArray(array, array.length);
    }

    public static final void printArray(int[] array, int n) {
        System.out.print("[");
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.printf("%d", array[i]);
        }
        System.out.println("]\n");
    }

}
