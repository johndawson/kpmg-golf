package com.kpmg.golf.tags;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang.StringUtils.EMPTY;

public final class UtilFunctions {
    private static final Logger log = LoggerFactory.getLogger(UtilFunctions.class);

    private UtilFunctions() {
    }

    public static String urlEncode(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);

            return url;
        }
    }

    public static String join(List<String> list, String separator, String format) {
        if (list == null) {
            return EMPTY;
        }

        Iterator<String> iterator = list.iterator();

        if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return String.format(format, ObjectUtils.toString(first));
        }

        StringBuffer buf = new StringBuffer(256);
        if (first != null) {
            buf.append(String.format(format, ObjectUtils.toString(first)));
        }

        while (iterator.hasNext()) {
            buf.append(separator);
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(String.format(format, ObjectUtils.toString(obj)));
            }
        }

        return buf.toString();
    }

    public static String quoteJson(String value) {
        return JSONObject.quote(value);
    }

    public static String ellipsis(String value, int length) {
        return com.kpmg.golf.utils.StringUtils.ellipsis(value, length);
    }

    public static String stripHtml(String value) {
        return com.kpmg.golf.utils.StringUtils.stripHtml(value);
    }

    public static String escapeHtml(String value) {
        return StringEscapeUtils.escapeHtml(value);
    }

    public static String escapeJavaScript (String value) {
        return StringEscapeUtils.escapeJavaScript(value);
    }

    public static Page pageParent(Page page) {
        return page.getParent();
    }
}
