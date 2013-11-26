<%@include file="/apps/golf-kpmg/components/global.jsp"%>

<div class="row marginb20">
    <div class="columns large-12 slider">
        <cq:include path="homeSlider" resourceType="golf-kpmg/components/content/homeSlider"/>
    </div>
</div>
<div class="main" role="main-content">
    <div class="row marginb20">
        <div class="large-2 small-4 columns donate-block w100percent">
            <cq:include path="rowContentParsys_1_1" resourceType="foundation/components/parsys" />
        </div>
        <div class="large-2 small-4 columns follow-block hide-smartphone-down">
            <cq:include path="rowContentParsys_1_2" resourceType="foundation/components/parsys" />
        </div>
        <div class="large-2 small-4 columns follow-block hide-smartphone-down">
            <cq:include path="rowContentParsys_1_3" resourceType="foundation/components/parsys" />
        </div>
        <div class="large-6 tablet-hide columns purchase-hat-block">
            <cq:include path="rowContentParsys_1_4" resourceType="foundation/components/parsys" />
        </div>
    </div>
    <div class="row">
        <div class="large-8 small-8 columns w100percent">
            <div class="row marginb20">
                <div class="large-6 small-6 columns video-block w100percent hide-smartphone-down">
                    <cq:include path="rowContentParsys_2_1" resourceType="foundation/components/parsys" />
                </div>
                <div class="large-6 small-6 columns blue-hat-block w100percent">
                    <cq:include path="rowContentParsys_2_2" resourceType="foundation/components/parsys" />
                </div>
            </div>
            <div class="row smart-phone-row marginb20">
                <div class="columns video-block w100percent">
                    <div class="video-block-content h140 small-h190">
                        <a href="" data-reveal-id="chipcharity"><img src="/content/dam/golf-kpmg/phone-video-ph.jpg"></a>
                        <div class="overlay-title"> <a href="" data-reveal-id="chipcharity">Phil's Chip4Charity on MNF</a> <a href="behind-the-scenes.htm" tppabs="http://www.golf-kpmg.com/behind-the-scenes"><span class="yellowtxt">+</span><span class="all-caps">More Videos</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row marginb20">
                <div class="large-6 small-6 columns news-block h140 small-h190 w100percent hide-smartphone-down">
                    <cq:include path="rowContentParsys_3_1" resourceType="foundation/components/parsys" />
                </div>
                <div class="large-6 small-6 columns event-block hide-smartphone-down">
                    <cq:include path="rowContentParsys_3_2" resourceType="foundation/components/parsys" />
                </div>
            </div>
        </div>
        <div class="large-4 small-4 columns twitter-block w100percent">
            <cq:include path="rightRailParsys_1" resourceType="foundation/components/parsys" />
        </div>
    </div>
</div>
<cq:include path="footerContentParsys_1" resourceType="foundation/components/parsys" />