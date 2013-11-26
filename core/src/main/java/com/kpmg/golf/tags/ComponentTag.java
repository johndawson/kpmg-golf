package com.kpmg.golf.tags;

import com.kpmg.golf.content.Component;
import com.kpmg.golf.content.ComponentContext;
import com.kpmg.golf.content.impl.ComponentContextImpl;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Constructor;

public final class ComponentTag extends TagSupport
{
    private static final Logger log = LoggerFactory.getLogger(ComponentTag.class);
    private static final long serialVersionUID = 1L;
    private String className;
    private String var;

    public int doStartTag()
            throws JspTagException
    {
        log.debug("doStartTag() class name = {}", this.className);
        try
        {
            Class clazz = Class.forName(this.className);

            if (clazz.isAnnotationPresent(Component.class))
            {
                ComponentContext context = new ComponentContextImpl(this.pageContext);

                Constructor constructor = clazz.getConstructor(new Class[] { ComponentContext.class });

                Object component = constructor.newInstance(new Object[] { context });

                if (StringUtils.isEmpty(this.var))
                    this.pageContext.setAttribute("currentComponent", component, 2);
                else
                    this.pageContext.setAttribute(this.var, component, 2);
            }
            else {
                throw new IllegalArgumentException("content class is not properly annotated = " + this.className);
            }
        } catch (Exception e) {
            log.error("Error instantiating class = {}", this.className);
            log.error(e.getMessage(), e);

            throw new JspTagException(e);
        }

        return EVAL_BODY_INCLUDE;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setVar(String var) {
        this.var = var;
    }
}