package com.kpmg.golf;

import org.apache.sling.api.resource.ValueMap;

import com.day.cq.wcm.api.Page;

public final class RedirectPath {

    private RedirectPath() {
        super();
    }

    public static String getRedirectPath(Page page, String pathPage) {
        ValueMap mp = page.getProperties();
        String redirect;
        if (mp.get("redirectTarget") != null) {
            redirect = (String) mp.get("redirectTarget");
        } else {
            redirect = pathPage;
        }
        redirect = checkPath(redirect);
        return redirect;

    }

    public static String checkPath(String path) {
        boolean hasHref = (path != null && !path.isEmpty());

        //Is the link external? Yes, if it starts with http: or https:
        boolean isExternal = (hasHref && (path.startsWith("http:") || (path.startsWith("https:"))));

        //Is the link internal? Yes, if it starts with /
        boolean isInternal = (hasHref && path.startsWith("/"));

        //Is the link a mailto link? Yes, if it starts with mailto:
        boolean isMailto = (hasHref && path.startsWith("mailto:"));

        //Is the link an anchor link? Yes, if it contains an octothorpe
        boolean isAnchorLink = (hasHref && path.contains("#"));

        //Is the link a link to an app? Yes, if it contains a ?
        boolean isAppLink = (hasHref && path.contains("?"));

        //Does the link have a suffix? Yes, if it contains a dot
        boolean hasSuffix = (hasHref && path.contains("."));

        String res = path;

        if (!isExternal && isInternal && !isAnchorLink && !isAppLink && !hasSuffix && !isMailto) {
            res += ".html";
        }

        return res;
    }

}
