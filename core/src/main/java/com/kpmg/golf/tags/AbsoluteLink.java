package com.kpmg.golf.tags;

import com.day.cq.commons.Externalizer;
import com.day.cq.wcm.api.components.IncludeOptions;
import com.kpmg.golf.utils.ServiceUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class AbsoluteLink extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String path;

    public AbsoluteLink() {
        super();
    }

    @Override
    public int doStartTag() throws JspException {
        SlingHttpServletRequest request = TagUtil.getRequest(pageContext);
        String url = null;

        if (StringUtils.isNotEmpty(path)) {
            Externalizer externalizer = ServiceUtils.getService(request, Externalizer.class);

            url = externalizer.absoluteLink(request, request.getScheme(), path);
        } else {
            StringBuilder builder = new StringBuilder();

            builder.append(request.getScheme()).append("://");
            builder.append(getAuthority(request.getScheme(), request.getServerName(), request.getServerPort()));

            url = builder.toString();
        }
        try {
            if (StringUtils.isNotEmpty(url)) {
                pageContext.getOut().write(url);
            }
        } catch (IOException e) {
            throw new JspException(e);
        }

        return SKIP_BODY;
    }

    public static String getAuthority(String scheme, String host, int port) {
        if ((port <= 0) || (("http".equals(scheme)) && (port == 80)) || (("https".equals(scheme)) && (port == 443))) {
            return host;
        }
        return host + ":" + port;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
