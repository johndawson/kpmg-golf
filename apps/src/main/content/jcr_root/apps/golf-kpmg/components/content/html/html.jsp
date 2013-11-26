<%@include file="/apps/golf-kpmg/components/global.jsp"%>

<golf:ifWcmMode modes="edit">
    <p>Click here to view HTML code</p>
    <c:out value="${properties.html}" escapeXml="false" />
</golf:ifWcmMode>

<golf:ifWcmMode modes="edit" evaluate="false">
    <c:out value="${properties.html}" escapeXml="false" />
</golf:ifWcmMode>
