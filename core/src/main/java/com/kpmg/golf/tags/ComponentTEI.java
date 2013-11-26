package com.kpmg.golf.tags;

import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;

public class ComponentTEI extends TagExtraInfo {
    @Override
    public VariableInfo[] getVariableInfo(final TagData data) {
        String var = data.getAttributeString("var");

        if (var == null) {
            var = "currentComponent";
        }

        return new VariableInfo[] {
                new VariableInfo(var,
                        data.getAttributeString("className"),
                        true, VariableInfo.AT_BEGIN)
        };
    }
}
