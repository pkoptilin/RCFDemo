<!-- begin inc_dyn_subHeaderBorrower.jsp -->
<%@ include file="/inc/jsp_pl_header.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title><%= navbean.getTitle() %></title>
<% if (navbean.isRefreshPage()) { %><meta http-equiv="refresh" content="<%=navbean.getRefreshInterval()%>"><% } %>
<% boolean isMobile = com.selectica.accountmanagement.RequestStateHolder.isMobile();
boolean clientMode = com.selectica.tools.DetermineUtils.isClientMode(com.selectica.accountmanagement.RequestStateHolder.getHttpRequest());
   if(isMobile){
%>
<%@ include file="/privateLabels/rcfdev/inc_dyn_mobile_subHeaderBorrower.jsp" %>
<% }else{ %>
<script language="javascript" type="text/javascript">var appContext = '<%=com.selectica.startup.AppLoader.CURRENT_CONTEXT%>';</script>
<script language="javascript" type="text/javascript" src="js/aculo/prototype.js"></script>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<%  String localeLanguage = userbean.getLocaleLanguage();
    if (localeLanguage == null || localeLanguage.equals("")) localeLanguage = "en"; // default to en if none available
    out.println("<script language=\"javascript\" type=\"text/javascript\" src=\"js/language_" + localeLanguage +".js\"></script>");
%>

<script language="JavaScript" type="text/javascript" src="js/remoteScripting.js"></script>
<script language="JavaScript" type="text/javascript" src="js/help.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/adapter/ext/ext-base.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/ext-all.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-utils.js"></script>
<link rel="stylesheet" type="text/css" href="js/ext-3.4.0/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="styles/extjs_custom.css" />

<script language="JavaScript" type="text/javascript">
    Ext.BLANK_IMAGE_URL = 'pix/s.gif';
    Ext.SSL_URL = 'html/blank.html';
</script>

    <script language="JavaScript" type="text/javascript" src="privateLabels/rcfdev/new_ui/main.js"></script>
    <link rel="stylesheet" type="text/css" href="privateLabels/rcfdev/new_ui/main.css" />

    <script language="JavaScript" type="text/javascript">
        window.externalParams =
        {
            <%
            com.selectica.controller.WorkflowSession workflowSession = userbean.getWorkflowSession(request, response);
            String path = request.getParameter(com.selectica.controller.ActionManager.NAVIGATION_TAG);
            if(path == null){
                 path = workflowSession.getActiveNavigation().getPath();
            }
            %>
            nav: "<%=path%>",
            isDisabledNav: <%=workflowSession.getDataState().getPreviousState()!= null%>
        };
    </script>


    <!-- !reddoor -->
<script language="JavaScript" type="text/javascript" src="js/calendar.js"></script>
<%	if (localeLanguage == null || localeLanguage.equals("")) localeLanguage = "en"; // default to en if none available
out.println("<script language=\"javascript\" type=\"text/javascript\" src=\"js/calendar-" + localeLanguage +".js\"></script>");
%>
<script language="JavaScript" type="text/javascript" src="js/calendar-setup.js"></script>
<script language="JavaScript" type="text/javascript" src="js/calendar_supplemental.js"></script>
<!-- !reddoor -->

<%--<script language="javascript" type="text/javascript" src="js/tinymce/jscripts/tiny_mce/tiny_mce_src.js"></script>--%>
<script language="JavaScript" type="text/javascript" src="js/aculo/scriptaculous.js"></script>
<script language="javascript" type="text/javascript">
    User.setLanguage("<%=localeLanguage%>");
    //HTMLStringFieldManager.initialize("<%=localeLanguage%>");
</script>
<script language="JavaScript" type="text/javascript"><!--// Returns dynamic header and footer elements for static pages //-->
urlString = document.location.href;
indexAfterHttp  = urlString.indexOf("//")+2;
firstPointIndex =  urlString.indexOf(".");
plDom = urlString.substr(indexAfterHttp,firstPointIndex-indexAfterHttp);
function getCookie(NameOfCookie){
    if (document.cookie.length > 0) {
        begin = document.cookie.indexOf(NameOfCookie+"=");
        if (begin != -1) {
            begin += NameOfCookie.length+1;
            end = document.cookie.indexOf(";", begin);
            if (end == -1) end = document.cookie.length;
            return unescape(document.cookie.substring(begin, end));
        }
    }
  return null;
}
locale=getCookie('locale');
if (locale==null) {
    locale=document.location.href;setCookie('plDom',plDom,365);
}
</script>

<%@ include file="/inc/additional_js_css.jsp" %>

<!-- begin timout functions -->
<script language="JavaScript" type="text/javascript">var popupName = 'TimeOut'+(new Date()).getSeconds();</script>
<%@ include file="/inc/set_timeout.jsp" %>
<!-- end timeout functions -->

<link rel="stylesheet" href="styles/skin.css" id="styletag" media="screen" />
<%= com.selectica.render.util.DisplayManager.getStyleSheetLink(request) %>
<link rel="alternate stylesheet" type="text/css" title="print" href="styles/print.css" media="screen" />
<link rel="stylesheet" href="styles/print.css" media="print" />
<%  String personalSkinURL = com.selectica.render.util.DisplayManager.getPersonalSkinStyle(request);
    if(personalSkinURL != null && personalSkinURL !="")
    {
%>
    <%=personalSkinURL%>
<%  }%>
<style type="text/css">.PublicFaqFooter{display:none}</style>

</head>
<body onUnload="closeDep()" onbeforeunload="browserForward()">
<%@ include file="/inc/ribbon_notification.jsp" %>
<div id='msgDiv'></div>

<div id="container-wrapper">
    <div id="viewport-wrapper">
    </div>
</div>

<%=com.selectica.render.util.DisplayManager.getFailOverMessage(request)%>
<div id="north">
<%if(!clientMode){%>
<%=com.selectica.render.util.DisplayManager.getIncludeHtml(request, "html/header.html")%>
<%}%>
<%= navbean.getHelpPopupHTML()%>
<% }//end of else(!isMobile) %>

<!-- end inc_dyn_subHeaderBorrower.jsp -->