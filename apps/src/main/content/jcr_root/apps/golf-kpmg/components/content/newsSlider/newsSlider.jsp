<%@include file="/apps/golf-kpmg/components/global.jsp" %>
<%@page session="false" %>

<golf:component className="com.kpmg.golf.components.RoyalSliderComponent"/>

<div class="news-slider-outer h140">
    <div id="news-slider" class="news-slider">
        <c:forEach var="item" items="${sliderItems}" varStatus="status">
            <div class="news-slide ${item.twoDigitLeft eq 'true' ? "twodigitleft" : ""}">
                <div class="number-count left ${item.littleNumber eq 'true' ? "littlenumber" : ""}">${item.count}</div>
                <div class="news-content left ${item.fullWidth eq 'true' ? "fullwidth" : ""}">
                    ${item.description}
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<cq:include path="newsSliderItemParsys" resourceType="foundation/components/parsys"/>
