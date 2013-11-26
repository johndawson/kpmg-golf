package com.kpmg.golf.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

/**
 * Created with IntelliJ IDEA.
 * User: andrey.zelentsov
 * Date: 30.09.13
 * Time: 16:10
 */
public class Slider {

    private static final Logger logger = LoggerFactory.getLogger(Slider.class);

    private static final String DL_IMAGE = "image";

    private static final String DL_IMAGE_MOBILE = "imageMobile";

    private static final String DESCRIPTION = "description";

    private static final String VIDEO_LINK = "videoLink";

    private static final String READ_MORE_IMAGE = "readMoreImage";

    private static final String READ_MORE_TEXT = "readMore";

    private static final String COUNT = "count";

    private static final String TWO_DIGIT_LEFT = "twodigitleft";

    private static final String LITTLE_NUMBER = "littlenumber";

    private static final String FULL_WIDTH = "fullwidth";

    private final Node node;

    public Slider (Node node) {
        this.node = node;
    }

    private String getStringValue(String propName) {
        String value = "";
        try {
            if (this.node.hasProperty(propName)) {
                value = this.node.getProperty(propName).getValue().getString();
            }
        } catch (ValueFormatException e) {
            logger.error(e.getMessage(), e);
        } catch (PathNotFoundException e) {
            logger.error(e.getMessage(), e);
        } catch (RepositoryException e) {
            logger.error("[Slider]Can't get property from single Node[" + this.node + "]", e);
        }
        return value;
    }

    public String getImage() {
        return getStringValue(DL_IMAGE);
    }

    public String getMobileImage() {
        return getStringValue(DL_IMAGE_MOBILE);
    }

    public String getDescription() {
        return getStringValue(DESCRIPTION);
    }

    public String getVideoLink() {
        return getStringValue(VIDEO_LINK);
    }

    public String getReadMoreImage() {
        return getStringValue(READ_MORE_IMAGE);
    }

    public String getReadMoreText() {
        return getStringValue(READ_MORE_TEXT);
    }

    public String getCount() {
        return getStringValue(COUNT);
    }

    public String getTwoDigitLeft() {
        return getStringValue(TWO_DIGIT_LEFT);
    }

    public String getLittleNumber() {
        return getStringValue(LITTLE_NUMBER);
    }

    public String getFullWidth() {
        return getStringValue(FULL_WIDTH);
    }

}
