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
    FileName: LinkedListNode.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.list.linked.data;

import com.lq186.algorithm.data.INodeData;
import lombok.Data;

@Data
public final class LinkedListNode<T extends INodeData> {

    private T data;

    private LinkedListNode nextNode;

}
