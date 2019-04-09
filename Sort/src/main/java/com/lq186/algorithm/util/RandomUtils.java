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
    FileName: RandomUtils.java
    Date: 2019/4/6
    Author: lq
*/
package com.lq186.algorithm.util;

import java.util.Random;

public final class RandomUtils {

    private static final char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    public static final int[] randomIntArray(int length) {
        final int[] array = new int[length];
        final Random random = new Random();
        for (int i = 0; i < length; ++i) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static final String[] randomStringArray(int length) {
        final Random random = new Random();
        final int stringLength = random.nextInt(5) + 5;
        final int charsLength = CHARS.length;
        final String[] array = new String[length];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            stringBuilder.setLength(0);
            for (int c = 0; c < stringLength; ++c) {
                stringBuilder.append(CHARS[random.nextInt(charsLength)]);
            }
            array[i] = stringBuilder.toString();
        }
        return array;
    }

}
