package com.kpmg.golf.tags;

import com.day.cq.wcm.api.WCMMode;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("UnusedDeclaration")
public final class IfWcmModeTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String[] modes;
    private Boolean evaluate = Boolean.TRUE;

    public IfWcmModeTag() {
        super();
    }

    @Override
    public int doStartTag() {
        WCMMode currentMode = WCMMode.fromRequest(TagUtil.getRequest(pageContext));

        String mode = currentMode.name().toLowerCase();

        if (evaluate == null || Boolean.TRUE.equals(evaluate)) {
            return ArrayUtils.contains(modes, mode) ? EVAL_BODY_INCLUDE : SKIP_BODY;
        } else {
            return ArrayUtils.contains(modes, mode) ? SKIP_BODY : EVAL_BODY_INCLUDE;
        }
    }

    public void setModes(final String modes) {
        this.modes = StringUtils.split(StringUtils.replace(modes, " ", ""), ",");
    }

    public void setEvaluate(final Boolean evaluate) {
        this.evaluate = evaluate;
    }
}
