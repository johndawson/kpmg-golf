package com.kpmg.golf.utils;

import com.kpmg.golf.content.ComponentContext;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.api.scripting.SlingScriptHelper;

import javax.servlet.ServletRequest;

public class ServiceUtils {

    private ServiceUtils() {
        super();
    }

    public static final <T> T getService(final ComponentContext context, final Class<T> serviceType) {

        if (context == null) {
            throw new UnsupportedOperationException("cannot get a service reference without an instance of " + ComponentContext.class.getName());
        } else {
            final SlingBindings bindings = (SlingBindings) context.getSlingRequest().getAttribute(SlingBindings.class.getName());

            final T service;

            if (bindings == null) {
                service = null;
            } else {
                final SlingScriptHelper sling = bindings.getSling();

                service = sling == null ? null : sling.getService(serviceType);
            }

            return service;
        }
    }

    public static <T> T getService(ServletRequest request, final Class<T> serviceType) {
        if (request == null) {
            throw new IllegalArgumentException("Request is null, Class = " + serviceType);
        } else {
            SlingBindings bindings = (SlingBindings) request.getAttribute(SlingBindings.class.getName());
            T service;

            if (bindings == null) {
                return null;
            } else {
                SlingScriptHelper sling = bindings.getSling();
                service = sling == null ? null : sling.getService(serviceType);
            }

            return service;
        }
    }
}
