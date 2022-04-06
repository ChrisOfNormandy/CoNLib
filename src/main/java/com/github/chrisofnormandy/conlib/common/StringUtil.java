package com.github.chrisofnormandy.conlib.common;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    /**
     * 
     * @param str
     * @return
     */
    public static final String wordCaps(String str) {
        String[] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++)
            arr[i] = StringUtils.capitalize(arr[i]);

        return String.join(" ", arr);
    }

    /**
     * 
     * @param str
     * @return
     */
    public static final String wordCaps_repl(String str) {
        return wordCaps(str.replace("_", " "));
    }
}
