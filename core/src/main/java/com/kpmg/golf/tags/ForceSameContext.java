package com.kpmg.golf.tags;

import com.day.cq.wcm.api.components.IncludeOptions;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ForceSameContext extends TagSupport {
    private static final long serialVersionUID = 1L;

    public ForceSameContext() {
        super();
    }

    @Override
    public int doStartTag() throws JspException {
        IncludeOptions.getOptions(TagUtil.getRequest(pageContext), true).forceSameContext(true);

        return super.doStartTag();
    }
}
