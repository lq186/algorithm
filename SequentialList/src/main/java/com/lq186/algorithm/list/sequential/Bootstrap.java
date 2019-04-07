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
    Date: 2019/4/5
    Author: lq
*/
package com.lq186.algorithm.list.sequential;

import com.lq186.algorithm.list.sequential.data.SequentialList;
import com.lq186.algorithm.data.NodeData;

import java.util.Scanner;

public final class Bootstrap {

    public static void main(String[] args) {

        SequentialList<NodeData> sequentialList = new SequentialList<>();

        System.out.println(">> 顺序表操作演示 >>");

        System.out.println(">> 初始化顺序表 >>");
        sequentialList.init();
        System.out.println(">> 顺序表初始化完成 >>");

        System.out.println(">> 添加结点 >>");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(">> 请输入添加的结点(学号 姓名 年龄) >>");
            System.out.println(">> 输入: 0 0 0 结束");

            NodeData nodeData = new NodeData();
            nodeData.setKey(scanner.next());
            nodeData.setName(scanner.next());
            nodeData.setAge(scanner.nextInt());

            if (0 == nodeData.getAge()) {
                break;
            }

            try {
                boolean isAddSuccess = sequentialList.add(nodeData);
                if (!isAddSuccess) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        } while (true);

        System.out.println(">> 顺序表中的结点信息 >>");
        sequentialList.display();

        System.out.println(">> 请输入查询结点的序号 >>");
        int index = scanner.nextInt();
        try {
            NodeData nodeData = sequentialList.get(index);
            System.out.printf("第[ %d ]个结点为：{key: %s, name: %s, age: %d}\n", index, nodeData.getKey(), nodeData.getName(), nodeData.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
