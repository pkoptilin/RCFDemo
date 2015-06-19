<!-- begin privateLabels/inc_dyn_subHome.jsp -->
<%@ include file="/inc/jsp_pl_header.jsp" %>
<% if (!userbean.isLoggedIn()) {%>
<jsp:useBean id="formbean" class="com.selectica.beangen.homeBean" scope="request" /><% if (request.getAttribute("UserName_Text_Error")!=null) { %>
<% formbean.UserName_Text_Error=true; %>
<% } %>
<% if (request.getAttribute("UserPW_Password_Error")!=null) { %>
<% formbean.UserPW_Password_Error=true; %>
<% } %>

<%String helpTitle =userbean.getLocalizedString("account.login");%>

<%
if(!com.selectica.accountmanagement.RequestStateHolder.isMobile()){
%>
<script language="javaScript" type="text/javascript">
Ext.onReady(function(){

	var viewport = new Ext.Viewport({
		layout:'border',
        applyTo: 'viewport-wrapper',
		items:[
			new Ext.BoxComponent({
				region:'north',
				el:'north',
				id:'north-panel',
				height:56,
				collapsible: false,
				border:false,
				margins:'0 0 0 0'
			}),{
				region:'south',
				contentEl:'south',
				id:'south-panel',
				split:false,
				height: 26,
				minSize: 26,
				maxSize: 26,
				collapsible: false,
				margins:'0 0 0 0',
				border:false
			},{
				region:'west',
				id:'west-panel',
				title:'<%= userbean.getLocalizedJavascriptEscapedString("accountLogin")%>',
				split:true,
				width: 250,
				minSize: 250,
				maxSize: 450,
				collapsible: false,
				margins:'0 0 0 5',
				autoScroll:true,
				items: [{
					contentEl: 'west',
					border:false,
					autoScroll:true,
					iconCls:'nav'
				}]
			},{
			region:'center',
			contentEl:'center',
			id:'center-panel',
			margins:'0 5 0 0',
			autoScroll: true,
			split:true,
			width:'100%'
		}]
	});
}
);
</script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/adapter/ext/ext-base.js"></script>
<script language="JavaScript" type="text/javascript" src="js/ext-3.4.0/ext-all.js"></script>

<script language="JavaScript" type="text/javascript">
    Ext.BLANK_IMAGE_URL = 'pix/s.gif';
    Ext.SSL_URL = 'html/blank.html';
</script>

<%@ include file="/inc/additional_js_css.jsp" %>
<%}	%>

	<div id="west">
			<div class="PlSb" id="PlSb">
				<% if (!userbean.getIsOfflineBuild()) { %>
				<% if (userbean.isNoUserType()) { %>
					<%@ include file="/inc/pl_login.jsp" %>
				<% } else { %>
				<div class="headerContent">
					<div class="Left">Your Account</div>
				</div>
				<fieldset class="Padding">
				<b><%= userbean.getUserName() %></b>,<br />
				<a id="getInstitutionName" title="<%= userbean.getInstitutionName() %>"><%= Validator.getTruncatedString(userbean.getInstitutionName(), 12) %></a>
				</fieldset>
				<% } %>
				<% } else { %>
				Our system is currently unavailable. Please check back later.
				<% } %>

			</div>
	</div>
	<div id="center">
		<div id="beginRender_CentCol">
			<div class="CentCol" style="padding:10px;"> <%=com.selectica.render.util.DisplayManager.getIncludeHtml(request, "html/homepage.html")%> </div>
		</div>
	</div>
<% } else { %>
<% String npage=userbean.getHomePage(); %>
<META HTTP-EQUIV="refresh" content="0;URL=<%=npage%>">
<% } %>
