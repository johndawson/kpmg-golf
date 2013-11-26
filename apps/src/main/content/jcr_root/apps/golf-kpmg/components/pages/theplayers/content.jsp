<%@include file="/apps/golf-kpmg/components/global.jsp" %>

<div class="row">
    <c:forEach begin="1" end="2" varStatus="status">
        <div class="large-6 small-6 columns w100percent">
            <div class="row marginb20">
                <div class="large-12 small-12 columns w100percent spadding0">
                    <cq:include path="contentTopParsys_${status.index}" resourceType="foundation/components/parsys"/>
                </div>
            </div>
            <div class="row marginb20">
                <div class="large-6 small-12 columns tmarginb20 smarginb20 w100percent">
                    <cq:include path="contentParsys_${status.index}_1" resourceType="foundation/components/parsys"/>
                </div>
                <div class="large-6 small-12 columns w100percent">
                    <cq:include path="contentParsys_${status.index}_2" resourceType="foundation/components/parsys"/>
                </div>
            </div>
            <div class="row marginb20">
                <div class="large-6 small-12 columns tmarginb20 smarginb20 w100percent">
                    <cq:include path="contentParsys_${status.index}_3" resourceType="foundation/components/parsys"/>
                </div>
                <div class="large-6 small-12 columns w100percent">
                    <cq:include path="contentParsys_${status.index}_4" resourceType="foundation/components/parsys"/>
                </div>
            </div>
        </div>
    </c:forEach>
</div>