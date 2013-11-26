package com.kpmg.golf.utils;

import org.apache.sling.api.resource.Resource;

public class JcrResourceUtils {

    public static final String CONTENT_NODE_NAME = "jcr:content";

    public static boolean isContentResource(Resource resource) {
        return resource != null && CONTENT_NODE_NAME.equals(resource.getName());
    }
}
