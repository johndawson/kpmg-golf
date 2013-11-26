package com.kpmg.golf.content;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMMode;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingScriptHelper;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.jsp.PageContext;

public interface ComponentContext {

    SlingHttpServletRequest getSlingRequest();

    SlingHttpServletResponse getSlingResponse();

    PageManager getPageManager();

    Page getCurrentPage();

    Node getCurrentNode();

    Resource getResource();

    ResourceResolver getResourceResolver();

    ValueMap getProperties();

    PageContext getPageContext();

    WCMMode getWcmMode();

    SlingScriptHelper getSling();

    Session getSession();
}
