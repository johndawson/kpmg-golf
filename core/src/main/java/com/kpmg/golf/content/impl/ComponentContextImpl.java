package com.kpmg.golf.content.impl;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMMode;
import com.kpmg.golf.content.ComponentContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.jsp.util.TagUtil;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.jsp.PageContext;

public class ComponentContextImpl implements ComponentContext {
    private final SlingHttpServletRequest slingRequest;
    private final SlingHttpServletResponse slingResponse;
    private final PageManager pageManager;
    private final Page currentPage;
    private final Node currentNode;
    private final Resource resource;
    private final ResourceResolver resourceResolver;
    private final ValueMap properties;
    private final PageContext pageContext;

    public ComponentContextImpl(final PageContext pageContext) {
        this.pageContext = pageContext;

        this.slingRequest = TagUtil.getRequest(pageContext);
        this.slingResponse = TagUtil.getResponse(pageContext);

        this.pageManager = (PageManager)pageContext.getAttribute("pageManager");
        this.currentPage = (Page)pageContext.getAttribute("currentPage");

        this.currentNode = (Node)pageContext.getAttribute("currentNode");

        this.resource = (Resource)pageContext.getAttribute("resource");
        this.resourceResolver = this.resource.getResourceResolver();

        this.properties = (ValueMap)pageContext.getAttribute("properties");
    }

    @Override
    public SlingHttpServletRequest getSlingRequest() {
        return slingRequest;
    }

    @Override
    public SlingHttpServletResponse getSlingResponse() {
        return slingResponse;
    }

    @Override
    public PageManager getPageManager() {
        return pageManager;
    }

    @Override
    public Page getCurrentPage() {
        return currentPage;
    }

    @Override
    public Node getCurrentNode() {
        return currentNode;
    }

    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }

    @Override
    public ValueMap getProperties() {
        return properties;
    }

    @Override
    public PageContext getPageContext() {
        return pageContext;
    }

    @Override
    public WCMMode getWcmMode() {
        return WCMMode.fromRequest(this.slingRequest);
    }

    @Override
    public SlingScriptHelper getSling() {
        SlingBindings bindings = (SlingBindings)this.slingRequest.getAttribute(SlingBindings.class.getName());

        return bindings.getSling();
    }

    @Override
    public Session getSession() {
        return (Session)this.resourceResolver.adaptTo(Session.class);
    }

}
