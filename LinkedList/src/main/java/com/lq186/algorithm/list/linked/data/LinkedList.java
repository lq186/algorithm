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
    FileName: LinkedList.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.list.linked.data;

import com.lq186.algorithm.List;
import com.lq186.algorithm.data.INodeData;

public final class LinkedList<T extends INodeData> implements List<T> {

    /**
     * 未发现元素索引
     */
    private static final int NOT_FOUND_INDEX = -1;

    private LinkedListNode<T> firstNode;

    private LinkedListNode<T> lastNode;

    private transient int length;

    @Override
    public void init() {
        clearList(firstNode);
        firstNode = null;
    }

    private void clearList(LinkedListNode<T> node) {
        if (null != node) {
            if (null != node.getNextNode()) {
                clearList(node.getNextNode());
            }
            node.setNextNode(null);
            node.setData(null);
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public T get(int index) {
        if (0 > index || length <= index) {
            throw new RuntimeException("index out of bounds");
        }
        LinkedListNode<T> node = firstNode;
        for (int i = 1; i <= index; ++i) {
            node = node.getNextNode();
        }
        return node.getData();
    }

    @Override
    public int indexOf(T element) {
        if (null == element) {
            return NOT_FOUND_INDEX;
        }
        LinkedListNode<T> node = firstNode;
        for (int i = 0; i < length; ++i) {
            if (element == node.getData() || element.equals(node.getData())) {
                return i;
            }
            node = node.getNextNode();
        }
        return NOT_FOUND_INDEX;
    }

    @Override
    public boolean insert(T element, int index) {
        if (0 > index || length < index) {
            throw new RuntimeException("index out of bounds");
        }
        LinkedListNode<T> node = new LinkedListNode<>();
        node.setData(element);
        if (0 == index) {
            node.setNextNode(firstNode);
            firstNode = node;
        } else if (length == index) {
            lastNode.setNextNode(node);
            lastNode = node;
        } else {
            LinkedListNode<T> posNode = firstNode;
            LinkedListNode<T> posNextNode = posNode.getNextNode();
            for (int i = 1; i < index; ++i) {
                posNode = posNode.getNextNode();
                posNextNode = posNode.getNextNode();
            }
            posNode.setNextNode(node);
            node.setNextNode(posNextNode);
        }

        length++;
        return true;
    }

    @Override
    public boolean add(T element) {
        LinkedListNode<T> node = new LinkedListNode<>();
        node.setData(element);
        if (0 == length) {
            firstNode = node;
            lastNode = node;
        } else {
            lastNode.setNextNode(node);
            lastNode = node;
        }
        length++;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        if (0 > index || length <= index) {
            throw new RuntimeException("index out of bounds");
        }
        if (0 == index) {
            firstNode = firstNode.getNextNode();
        } else {
            LinkedListNode<T> posNode = firstNode;
            LinkedListNode<T> posRemovedNode = firstNode.getNextNode();
            for (int i = 1; i < index; ++i) {
                posNode = posNode.getNextNode();
                posRemovedNode = posNode.getNextNode();
            }
            posNode.setNextNode(posRemovedNode.getNextNode());
            if (length - 1 == index) {
                lastNode = posNode;
            }
        }
        length--;
        return true;
    }

    @Override
    public void display() {
        LinkedListNode<T> node = firstNode;
        while (null != node) {
            System.out.printf("{Key: %s}\n", (null == node.getData()) ? "NULL" : node.getData().getKey());
            node = node.getNextNode();
        }
    }

}
