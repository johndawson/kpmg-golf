package com.kpmg.golf.tags;

import com.day.cq.commons.Externalizer;
import com.kpmg.golf.utils.ServiceUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public final class Url extends BodyTagSupport {
    private static final long serialVersionUID = 9200103877381469990L;
    private String value;
    private Boolean map = Boolean.FALSE;

    public Url() {
        super();
        init();
    }

    private void init() {
        this.value = null;
        this.map = Boolean.FALSE;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int doStartTag() throws JspException {
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            this.pageContext.getOut().print(resolveUrl());
        } catch (IOException ex) {
            throw new JspTagException(ex.toString(), ex);
        }

        return EVAL_PAGE;
    }

    private String resolveUrl() throws JspException {
        String url = this.value;

        if (map) {
            SlingHttpServletRequest request = TagUtil.getRequest(pageContext);
            Externalizer externalizer = ServiceUtils.getService(request, Externalizer.class);

            url = externalizer.relativeLink(request, url);
        }

        if (url != null && url.startsWith("/") && !url.endsWith(".html")) {
            return url + ".html";
        }

        return url;
    }

    @Override
    public void release() {
        init();
    }

    public void setMap(final Boolean map) {
        this.map = map;
    }
}
