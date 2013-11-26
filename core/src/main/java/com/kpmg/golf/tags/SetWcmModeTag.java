package com.kpmg.golf.tags;

import com.day.cq.wcm.api.WCMMode;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SetWcmModeTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String mode;
    private WCMMode oldWcmMode;

    public SetWcmModeTag() {
        super();
    }

    @Override
    public int doStartTag() {
        if (StringUtils.isNotEmpty(mode)) {
            ServletRequest request = TagUtil.getRequest(pageContext);

            oldWcmMode = WCMMode.fromRequest(request);

            WCMMode.valueOf(mode.toUpperCase()).toRequest(request);

            return EVAL_BODY_INCLUDE;
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        if (oldWcmMode != null) {
            oldWcmMode.toRequest(TagUtil.getRequest(pageContext));

            oldWcmMode = null;
        }

        return EVAL_PAGE;
    }

    public void setMode(final String mode) {
        this.mode = mode;
    }
}
