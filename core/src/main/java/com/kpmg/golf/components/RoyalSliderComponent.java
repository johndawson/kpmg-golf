package com.kpmg.golf.components;

import com.kpmg.golf.beans.Slider;
import com.kpmg.golf.content.AbstractComponent;
import com.kpmg.golf.content.ComponentContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.servlet.jsp.PageContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey.zelentsov
 * Date: 20.09.13
 * Time: 15:44
 */
public class RoyalSliderComponent extends AbstractComponent {

    public RoyalSliderComponent(ComponentContext componentContext) {
        super(componentContext);
        this.componentContext = componentContext;
        loadParsysParams();
    }

    private static final Logger logger = LoggerFactory.getLogger(RoyalSliderComponent.class);

    private static final String NODE_NAME_DL = "homeSlider";

    private static final String PARSYS_NAME_ROYAL_SLIDER_ITEM = "homeSliderItemParsys";

    private static final String PARSYS_NAME_NEWS_SLIDER_ITEM = "newsSliderItemParsys";

    private ComponentContext componentContext;

    private PageContext pageContext;

    public void loadParsysParams() {
        this.pageContext = this.componentContext.getPageContext();
        SlingHttpServletRequest req = (SlingHttpServletRequest) this.pageContext.getRequest();
        List<Slider> sliderItems = new ArrayList<Slider>();
        String parentNodeParsysPath = "";
        Node currentNode = this.componentContext.getCurrentNode();
        String parsysName = "";
        if (currentNode != null) {
            try {
                parentNodeParsysPath = currentNode.getPath();
                parsysName = currentNode.getName().equals(NODE_NAME_DL) ? PARSYS_NAME_ROYAL_SLIDER_ITEM : PARSYS_NAME_NEWS_SLIDER_ITEM;
            } catch (RepositoryException e) {
                logger.error("RoyalSliderComponent]Can't get path to current Node["
                        + currentNode + "]");
            }
            if (!"".equals(parentNodeParsysPath)) {
                String parsysPath = parentNodeParsysPath + "/" + parsysName;
                Resource resNode = req.getResourceResolver().resolve(parsysPath);
                Node chosenNode = resNode.adaptTo(Node.class);

                if (chosenNode != null) {
                    NodeIterator allNodes = null;
                    try {
                        allNodes = chosenNode.getNodes();
                    } catch (RepositoryException e) {
                        logger.error("[RoyalSliderComponent]Can't get nodes to chosen Node[" + chosenNode + "]");
                    }
                    if (allNodes != null) {
                        while (allNodes.hasNext()) {
                            Node singleNode = allNodes.nextNode();
                            sliderItems.add(new Slider(singleNode));
                        }
                    }
                }
            }
        }
        this.pageContext.setAttribute("sliderItems", sliderItems);
    }

}
