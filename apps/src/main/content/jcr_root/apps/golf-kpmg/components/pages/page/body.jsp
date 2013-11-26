<%@include file="/apps/golf-kpmg/components/global.jsp" %>

<c:set var="videoBlocksCount" value="0" scope="application"/>
<c:set var="readBlocksCount" value="0" scope="application"/>
<c:set var="youtubePagePref" value="https://www.youtube.com/embed/" scope="application"/>

<body class="${currentPage.name}-page">
<div class="outer-wrap">
    <header class="header">
        <cq:include script="header.jsp"/>
    </header>

    <!--- MODALS_1 -->
    <div id="modals_modules"></div>
    <!--- END MODALS_1 -->

    <cq:include script="content.jsp"/>

    <!--- MODALS_2 -->
    <cq:include path="editorModals" resourceType="golf-kpmg/components/content/html"/>
    <!--- END MODALS_2 -->

    <footer class="footer">
        <cq:include script="footer.jsp"/>
    </footer>

    <script>
        $(function(){
            $("#home-slider").royalSlider({
                arrowsNavAutoHide: false,
                sliderDrag: false,
                autoScaleSlider: true,
                loop: true,
                navigateByClick: false
            });
            $("#news-slider").royalSlider({
                arrowsNavAutoHide: false,
                arrowsNav: false,
                sliderDrag: false
            });
            $("#news-slider2").royalSlider({
                arrowsNavAutoHide: false,
                arrowsNav: false,
                sliderDrag: false
            });
            $('.follow-block-content').on('click', function(){
                var $tweetURL = $(this).find('.twitter-handle').attr('href');
                window.open($tweetURL,'_blank');
            });
            $('.donate-overlay').on('click', function() {
                var $bluebookLink = $(this).find('a').attr('href');
                window.open($bluebookLink,'_self');
            });
            $('.donate-overlay a').on('click', function(e) {
                e.preventDefault();
            });
            $("#performance-slider").royalSlider({
                arrowsNavAutoHide: false,
                sliderDrag: false,
                //autoScaleSlider: true,
                loop: true,
                navigateByClick: false
            });
        });
    </script>


    <script>
        $(function () {
            $('.mobile-menu-button').on('click', function () {
                $('.close-txt').toggle();
                $('.menu-icon').toggle();
                $('.menu-icon-close').toggle();
                $('.mobile-menu ul').toggle('fast');
            });
        });
    </script>
    <script>
        $(document).foundation();
    </script>
    <script>
        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
                    m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '/etc/designs/golf-kpmg/js/analytics.js', 'ga');

        ga('create', 'UA-43027397-1', 'http://www.golf-kpmg.com/golf-kpmg.com');
        ga('send', 'pageview');
    </script>
    <!-- SiteCatalyst code version: H.21.1.
        Copyright 1996-2010 Adobe, Inc. All Rights Reserved
        More info available at http://www.omniture.com -->
    <script language="JavaScript" type="text/javascript" src="/etc/designs/golf-kpmg/js/s_code.js"></script>
    <script language="JavaScript" type="text/javascript"><!--
    /* You may give each page an identifying name, server, and channel on the next lines. */
    s.pageName = ""
    s.server = ""
    s.channel = ""
    s.pageType = ""
    s.prop1 = ""
    s.prop2 = ""
    s.prop3 = ""
    s.prop4 = ""
    s.prop5 = ""
    /* Conversion Variables */
    s.campaign = ""
    s.state = ""
    s.zip = ""
    s.events = ""
    s.products = ""
    s.purchaseID = ""
    s.eVar1 = ""
    s.eVar2 = ""
    s.eVar3 = ""
    s.eVar4 = ""
    s.eVar5 = ""
    /************* DO NOT ALTER ANYTHING BELOW THIS LINE ! **************/
    var s_code = s.t();
    if (s_code)document.write(s_code)//-->
    </script>
    <script language="JavaScript" type="text/javascript"><!--
    if (navigator.appVersion.indexOf('MSIE') >= 0)document.write(unescape('%3C') + '\!-' + '-')
    //--></script>
    <noscript><img src="0-AQB=1&pccr=true&&cdp=3&AQE=1.gif"
                   tppabs="http://kpmgllp1.122.2o7.net/b/ss/kpmgllpphilprod/1/H.21.1--NS/0?[AQB]&cdp=3&[AQE]"
                   height="1" width="1" border="0" alt=""/></noscript>
    <!--/DO NOT REMOVE/-->
    <!-- End SiteCatalyst code version: H.21.1. -->
</div>
</body>