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
    FileName: Bootstrap.java
    Date: 2019/4/9
    Author: lq
*/
package com.lq186.algorithm.search;

import com.lq186.algorithm.util.PrintUtils;
import com.lq186.algorithm.util.RandomUtils;

import java.util.Scanner;

public final class Bootstrap {

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>> 顺序查找 >>>>>>>>>>>>>>>>");
        search(new SimpleSearch());
        System.out.println(">>>>>>>>>>>>>>>> 顺序查找 >>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>> 折半查找 >>>>>>>>>>>>>>>>");
        search(new BinarySearch());
        System.out.println(">>>>>>>>>>>>>>>> 折半查找 >>>>>>>>>>>>>>>>");
    }

    private static final void search(final ISearch search) {
        String[] array = RandomUtils.randomStringArray(10);
        System.out.println(">> 原始数据 >>");
        PrintUtils.printArray(array, array.length);

        Scanner scanner = new Scanner(System.in);
        System.out.println(">> 请输入要查找的数据 >>");
        final String searchKey = scanner.next();
        final int index = search.search(array, searchKey);
        if (index < 0) {
            System.out.println(">> 没有找到数据 >>");
        } else {
            System.out.printf(">> 数据 [%s] 位于数组的第 [%d] 个元素处\n", searchKey, index + 1);
        }
    }

}
