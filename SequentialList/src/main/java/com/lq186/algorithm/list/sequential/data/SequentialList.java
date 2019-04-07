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
    FileName: SequentialList.java
    Date: 2019/4/5
    Author: lq
*/
package com.lq186.algorithm.list.sequential.data;

import com.lq186.algorithm.List;
import com.lq186.algorithm.data.INodeData;

public final class SequentialList<T extends INodeData> implements List<T> {

    /**
     * 最大列表元素数量
     */
    private static final int MAX_ELEMENTS = 100;

    /**
     * 未发现元素索引
     */
    private static final int NOT_FOUND_INDEX = -1;

    /**
     * 元素数组
     */
    private final transient Object[] elements = new Object[MAX_ELEMENTS];

    /**
     * 表长度
     */
    private int length;

    /**
     * 初始化，清空表，长度设置为：0
     */
    public void init() {
        for (int i = 0; i < length; ++i) {
            elements[i] = 0;
        }
        this.length = 0;
    }

    /**
     * 获取表长度
     *
     * @return
     */
    public int length() {
        return length;
    }

    /**
     * 获取结点， 0 <= index < #SequentialList.MAX_ELEMENTS
     *
     * @param index 结点的索引
     * @return
     */
    public T get(int index) {
        if (index < 0 || length <= index) {
            throw new RuntimeException("index out of bounds");
        }
        return (T) elements[index];
    }

    /**
     * 查询元素位置
     *
     * @param element
     * @return
     */
    public int indexOf(T element) {
        if (null == element || null == element.getKey() || 0 >= length) {
            return NOT_FOUND_INDEX;
        }
        for (int i = 0; i < length; ++i) {
            if (element.getKey().equals(elements[i])) {
                return i;
            }
        }
        return NOT_FOUND_INDEX;
    }

    /**
     * 插入元素
     *
     * @param element
     * @param index   插入位置, 0 <= index <= #length()
     * @return
     */
    public boolean insert(T element, int index) {
        if (length >= MAX_ELEMENTS) {
            throw new RuntimeException("Sequential list is full");
        }
        if (0 > index || length < index) {
            throw new RuntimeException("index out of bounds");
        }
        for (int i = length - 1; i >= index; --i) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        length++;
        return true;
    }

    /**
     * 追加元素
     *
     * @param element
     * @return
     */
    public boolean add(T element) {
        if (length >= MAX_ELEMENTS) {
            throw new RuntimeException("Sequential list is full");
        }
        elements[length] = element;
        length++;
        return true;
    }

    /**
     * 移除元素
     *
     * @param index
     * @return
     */
    public boolean removeAt(int index) {
        if (0 > index || length <= index) {
            throw new RuntimeException("index out of bounds");
        }
        for (int i = index; i < length; i++) {
            elements[i] = elements[i + 1];
        }
        length--;
        return true;
    }

    /**
     * 显示所有元素
     */
    public void display() {
        for (int i = 0; i < length; ++i) {
            System.out.printf("{key: %s, index: %d}\n", ((T) elements[i]).getKey(), i);
        }
    }
}
