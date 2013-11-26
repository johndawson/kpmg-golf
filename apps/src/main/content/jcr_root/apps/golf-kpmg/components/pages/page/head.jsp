<%@page session="false"%><%--
  Copyright 1997-2010 Day Management AG
  Barfuesserplatz 6, 4001 Basel, Switzerland
  All Rights Reserved.

  This software is the confidential and proprietary information of
  Day Management AG, ("Confidential Information"). You shall not
  disclose such Confidential Information and shall use it only in
  accordance with the terms of the license agreement you entered into
  with Day.

  ==============================================================================

  Default head script.

  Draws the HTML head with some default content:
  - includes the WCML init script
  - includes the head libs script
  - includes the favicons
  - sets the HTML title
  - sets some meta data

  ==============================================================================

--%><%@include file="/libs/foundation/global.jsp" %><%
%><%@ page import="com.day.cq.commons.Doctype" %><%
    String xs = Doctype.isXHTML(request) ? "/" : "";
    String favIcon = currentDesign.getPath() + "/favicon.ico";
    if (resourceResolver.getResource(favIcon) == null) {
        favIcon = null;
    }
%><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"<%=xs%>>

    <cq:include script="headlibs.jsp"/>
    <cq:include script="/libs/wcm/core/components/init/init.jsp"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">

    <title>${not empty currentPage.title ? currentPage.title : currentPage.pageTitle}</title>
	
	<cq:include script="headSpecific.jsp"/>

    <link href="/etc/designs/golf-kpmg/css/normalize.css" media="screen" rel="stylesheet" type="text/css" >
    <link href="/etc/designs/golf-kpmg/css/foundation.css" media="screen" rel="stylesheet" type="text/css" >
    <link href="/etc/designs/golf-kpmg/css/royalslider.css" media="screen" rel="stylesheet" type="text/css" >
    <link href="/etc/designs/golf-kpmg/css/app.css" media="screen" rel="stylesheet" type="text/css" >

    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/jquery.min.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/foundation.min.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/foundation.reveal.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/custom.modernizr.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/jquery.royalslider.min.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/jquery.tmpl.min.js"></script>
    <script type="text/javascript" src="/etc/designs/golf-kpmg/js/tmplRender.js"></script>
    <!--[if IE 8]>
    <link rel="stylesheet" href="/etc/designs/golf-kpmg/css/ie-8-grid.css">
    <![endif]-->	
</head>
