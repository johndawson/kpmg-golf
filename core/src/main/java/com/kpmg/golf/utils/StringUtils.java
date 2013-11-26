package com.kpmg.golf.utils;

import static org.apache.commons.lang.StringUtils.EMPTY;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

public class StringUtils {
    private static String HTML_STRIP_REGEXP = "<(style|script)[^<>]*>.*?</\\1>|</?[a-z][a-z0-9]*[^<>]*>|<!--.*?-->";

    public static String ellipsis(String input, int length) {
        String output = EMPTY;

        if (isNotEmpty(input) && input.length() > 1 && length > 0 && input.length() > length) {
            if ('.' == input.charAt(length - 1) || '.' == input.charAt(length - 2)) {
                output = input.substring(0, length);
            } else if (' ' == input.charAt(length - 1) || ' ' == input.charAt(length - 2)) {
                output = input.substring(0, length);
            } else {
                if (length > 3) {
                    output = input.substring(0, length - 3).concat("...");
                }
            }
        } else {
            output = input;
        }

        return output;
    }

    public static String stripHtml(String html) {
        if (org.apache.commons.lang.StringUtils.isNotEmpty(html)) {
            return html.replaceAll(HTML_STRIP_REGEXP, "");
        }
        return org.apache.commons.lang.StringUtils.EMPTY;
    }

    public static final int compareToIgnoreCase(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return 0;
        } else if (s1 == null && s2 != null) {
            return -1;
        } else if (s1 != null && s2 == null) {
            return 1;
        } else {
            return s1.compareToIgnoreCase(s2);
        }
    }

}
