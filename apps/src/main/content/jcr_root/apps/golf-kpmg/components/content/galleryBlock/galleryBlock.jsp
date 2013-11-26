<%@include file="/apps/golf-kpmg/components/global.jsp"%>

<fmt:parseNumber var="videoBlocksCount" type="number" value="${applicationScope.videoBlocksCount == null ? 0 : applicationScope.videoBlocksCount}" />
<c:set var="videoBlocksCount" value="${applicationScope.videoBlocksCount + 1}" scope="application"/>
<c:set var="videoBlockId" value="video-block-${applicationScope.videoBlocksCount}"/>

<div class="video-block-content ${currentPage.path eq '/content/golf-kpmg/the-players' || currentPage.path eq '/content/golf-kpmg/blue-for-books' ? 'marginb20' : ''}">
	<a href="" class="reveal-link" data-reveal-id="${videoBlockId}">
		<img alt="" src="${properties.thumbnail}" data-interchange="[${properties.thumbnailMobile}, (default)], [${properties.thumbnail}, (only screen and (min-width: 769px))]" />
	</a>
    <c:choose>
        <c:when test="${empty properties.moreLink}">
            <a href="" class="reveal-link" data-reveal-id="${videoBlockId}">
                <span class="overlay-title left-align-title">
                    ${properties.title}
                </span>
            </a>
        </c:when>
        <c:otherwise>
            <div class="overlay-title">
                <span class="tablet-left">
                    <a href="" data-reveal-id="${videoBlockId}">${properties.title}</a>
                </span>
                <span class="tablet-right">
                    <a href="<golf:url value="${properties.moreLink}"/>">
                        <span class="yellowtxt">+</span>
                        <span class="all-caps">More <span class="talignl23">Videos</span>
                        </span>
                    </a>
                </span>
            </div>
        </c:otherwise>
    </c:choose>
</div>

<c:choose>
    <c:when test="${empty properties.type || 'video' eq properties.type}">

        <script id="videoBlockTemplate_${videoBlockId}" type="text/x-jquery-tmpl">
            <div id="\${vBlockId}" class="reveal-modal videomodal">
                <div class="modal-inner">
                    <div class="flex-video">
                        <iframe width="420" height="315" src="\${vLink}" frameborder="0" allowfullscreen></iframe>
                    </div>
                </div><a class="close-reveal-modal">&#215;</a>
            </div>
        </script>

        <c:set var="videoLink" value="${applicationScope.youtubePagePref}${properties.videoLink}"/>

        <c:choose>
            <c:when test="${fn:contains(fn:toLowerCase(properties.videoLink), 'youtube') && !fn:contains(fn:toLowerCase(properties.videoLink), 'https')}">
                <c:set var="videoLink" value="${fn:replace(fn:toLowerCase(properties.videoLink), 'http', 'https')}"/>
            </c:when>
            <c:otherwise>
                <c:if test="${fn:contains(fn:toLowerCase(properties.videoLink), 'youtube') && fn:contains(fn:toLowerCase(properties.videoLink), 'https')}">
                    <c:set var="videoLink" value="${properties.videoLink}"/>
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

    </c:when>
    <c:otherwise>
        <div id="g_${videoBlockId}" style="display: none">
            <c:forEach var="item" items="${properties.images}" varStatus="status">
                ${item}${not status.last ? ',' : ''}
            </c:forEach>
        </div>

        <script id="photoBlockTemplate_${videoBlockId}" type="text/x-jquery-tmpl">
            <div id="\${pBlockId}" class="reveal-modal photomodal">
                <div class="modal-inner">
                    <div id="gallery-\${pBlockId}" class="slider photo-gallery">
                        {{each(i, image) images}}
                        <img class="rsImg" src="\${image}" alt="">
                        {{/each}}
                    </div>
                </div><a class="close-reveal-modal">&#215;</a>
            </div>
        </script>

        <script type="text/javascript">
            var galleryBlock = new GalleryBlock({
                videoBlockId: '${videoBlockId}',
                images: jQuery('#g_${videoBlockId}').html().split(','),
                templateId: 'photoBlockTemplate_${videoBlockId}',
                renderTarget: 'modals_modules'
            });
        </script>
        <script>
            $(function(){
                $("#gallery-${videoBlockId}").royalSlider({
                    arrowsNavAutoHide: false,
                    sliderDrag: false,
                    imageScaleMode: 'fill',
                    loop: true,
                    navigateByClick: false
                });
            });
        </script>
    </c:otherwise>
</c:choose>










