package com.kpmg.golf.utils;

import org.apache.commons.httpclient.NameValuePair;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: andrey.zelentsov
 * Date: 19.09.13
 * Time: 18:43
 */
public class NvpComparator implements Comparator<NameValuePair> {

    /**
     * Sort list of oauth parameters by key names
     * @param arg0 first comparing parameter
     * @param arg1 second comparing parameter
     * @return sorted list
     */
    public int compare(NameValuePair arg0, NameValuePair arg1) {
        String name0 = arg0.getName();
        String name1 = arg1.getName();
        return name0.compareTo(name1);
    }

}
