<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/apps/golf-kpmg/components/global.jsp" %>
<%@page session="false" %>

<golf:component className="com.kpmg.golf.components.RoyalSliderComponent"/>

<c:set var="sliderId" value="${currentPage.path eq '/content/golf-kpmg/performances' ? 'performance-slider' : 'home-slider'}"/>
<c:set var="sliderClass" value="${currentPage.path eq '/content/golf-kpmg/performances' ? 'performance-slider royalSlider' : 'slide royalSlider'}"/>

<div class="${sliderClass}" id="${sliderId}">
    <c:forEach var="item" items="${sliderItems}" varStatus="status">
        <div class="main-slide-${status.count} hslide-content">
            <style>
                .main-slide-${status.count} {
                    background:url("${item.image}") no-repeat center top;
                    background-size: cover;

                }
                @media only screen and (max-width: 480px) {
                    .main-slide-${status.count} {
                        background:url("${item.mobileImage}") no-repeat center top;
                        background-size: cover;
                    }
                }
            </style>
            <div class="panel-content">
                ${item.description}
                    <c:if test="${not empty item.videoLink}">
                        <fmt:parseNumber var="videoBlocksCount" type="number" value="${applicationScope.videoBlocksCount == null ? 0 : applicationScope.videoBlocksCount}"/>
                        <c:set var="videoBlocksCount" value="${applicationScope.videoBlocksCount + 1}" scope="application"/>
                        <c:set var="videoBlockId" value="video-block-${applicationScope.videoBlocksCount}"/>

                        <a class="custom-watch-the-video" data-reveal-id="${videoBlockId}">View Here</a>

                        <script id="videoBlockTemplate_${videoBlockId}" type="text/x-jquery-tmpl">
                            <div id="\${vBlockId}" class="reveal-modal videomodal">
                                <div class="modal-inner">
                                    <div class="flex-video">
                                        <iframe width="420" height="315" src="\${vLink}" frameborder="0" allowfullscreen></iframe>
                                    </div>
                                </div><a class="close-reveal-modal">&#215;</a>
                            </div>
                        </script>

                        <c:set var="videoLink" value="${applicationScope.youtubePagePref}${item.videoLink}"/>

                        <c:choose>
                            <c:when test="${fn:contains(fn:toLowerCase(item.videoLink), 'youtube') && !fn:contains(fn:toLowerCase(item.videoLink), 'https')}">
                                <c:set var="videoLink" value="${fn:replace(fn:toLowerCase(item.videoLink), 'http', 'https')}"/>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${fn:contains(fn:toLowerCase(item.videoLink), 'youtube') && fn:contains(fn:toLowerCase(item.videoLink), 'https')}">
                                    <c:set var="videoLink" value="${item.videoLink}"/>
                                </c:if>
                            </c:otherwise>
                        </c:choose>

                        <script type="text/javascript">
                            var videoBlock = new VideoBlock({
                                videoBlockId: '${videoBlockId}',
                                videoLink: '${videoLink}',
                                templateId: 'videoBlockTemplate_${videoBlockId}',
                                renderTarget: 'modals_modules'
                            });
                        </script>
                    </c:if>
                    <c:if test="${not empty item.readMoreText}">
                        <fmt:parseNumber var="readBlocksCount" type="number" value="${applicationScope.readBlocksCount == null ? 0 : applicationScope.readBlocksCount}"/>
                        <c:set var="readBlocksCount" value="${applicationScope.readBlocksCount + 1}" scope="application"/>
                        <c:set var="readBlockId" value="read-block-${applicationScope.readBlocksCount}"/>

                        <a data-reveal-id="${readBlockId}" class="custom-watch-the-video">Read More</a>

                        <script id="readBlockTemplate_${readBlockId}" type="text/x-jquery-tmpl">
                            <div id="\${rBlockId}" class="reveal-modal textmodal">
                                <div class="modal-inner">
                                    <div class="modal-image">
                                        <img src="\${rBlockImage}"/>
                                    </div>
                                    <div class="modal-text">
                                        {{html rContent}}
                                    </div>
                                </div>
                                <a class="close-reveal-modal">&#215;</a>
                            </div>
                        </script>

                        <c:set var="textContent" value="${golf:escapeJS(item.readMoreText)}" />

                        <script type="text/javascript">
                            var readBlock = new ReadBlock({
                                readBlockId: '${readBlockId}',
                                readMoreImage: '${item.readMoreImage}',
                                readContent: '${textContent}',
                                templateId: 'readBlockTemplate_${readBlockId}',
                                renderTarget: 'modals_modules'
                            });
                        </script>
                    </c:if>
            </div>
        </div>
    </c:forEach>
</div>

<cq:include path="homeSliderItemParsys" resourceType="foundation/components/parsys"/>