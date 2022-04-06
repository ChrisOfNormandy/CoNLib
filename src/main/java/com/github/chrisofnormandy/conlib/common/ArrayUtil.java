package com.github.chrisofnormandy.conlib.common;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtil {
    /**
     * 
     * @param <T>
     * @param array
     * @param n
     * @return
     */
    public static final <T> ArrayList<T[]> split(T[] array, int n) {
        int l = array.length;

        ArrayList<T[]> list = new ArrayList<T[]>(n);

        int i = 0;
        int index = l / n;

        while (i < n) {
            list.add(Arrays.copyOfRange(array, index - l / n, index));
            i++;
            index += l / n;
        }

        return list;
    }
}
