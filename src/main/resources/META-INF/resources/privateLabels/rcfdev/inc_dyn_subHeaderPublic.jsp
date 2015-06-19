<!-- begin privateLabels/inc_dyn_subHeaderPublic.jsp -->
<%@ include file="/inc/jsp_pl_header.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title><%= HostInfo.getDisplayName() %> Login</title>
<% if (navbean.isRefreshPage()) { %><meta http-equiv="refresh" content="<%=navbean.getRefreshInterval()%>"><% } %>

<%
	boolean isMobile = com.selectica.accountmanagement.RequestStateHolder.isMobile();
    boolean clientMode = com.selectica.tools.DetermineUtils.isClientMode(com.selectica.accountmanagement.RequestStateHolder.getHttpRequest());
	if(!isMobile){
%>

	<link rel="stylesheet" type="text/css" href="styles/skin.css" />
<!--Stylesheet Request-->
	<%= com.selectica.render.util.DisplayManager.getStyleSheetLink(request) %>
	<% String personalSkinURL = com.selectica.render.util.DisplayManager.getPersonalSkinStyle(request); %>
	<% if(personalSkinURL != null && personalSkinURL !=""){ %>
		<%=personalSkinURL%>
	<% } %>
<script language="JavaScript" type="text/javascript" src="js/common.js"></script>
<script language="JavaScript" type="text/javascript" src="js/remoteScripting.js"></script>
<script language="JavaScript" type="text/javascript" src="js/help.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/adapter/ext/ext-base.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/ext-all.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-utils.js"></script>
<link rel="stylesheet" type="text/css" href="js/ext-3.4.0/resources/css/ext-all.css" />

<script language="JavaScript" type="text/javascript">
    Ext.BLANK_IMAGE_URL = 'pix/s.gif';
    Ext.SSL_URL = 'html/blank.html';
</script>

<%@ include file="/inc/additional_js_css.jsp" %>
<% }else{ %>
	<link href="styles/mobile.css" rel="stylesheet">
<% } %>

</head>
<body marginwidth="0" marginheight="0" leftmargin="0" topmargin="0">
<%@ include file="/inc/ribbon_notification.jsp" %>
<div id="north">
<%if(!clientMode){%>
<%=com.selectica.render.util.DisplayManager.getIncludeHtml(request, "html/header.html")%>
<%}%>
</div>
<!-- end privateLabels/inc_dyn_subHeaderPublic.jsp -->
