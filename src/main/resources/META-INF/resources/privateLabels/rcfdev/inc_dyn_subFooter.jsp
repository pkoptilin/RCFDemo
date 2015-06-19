<!-- begin privateLabel/inc_dyn_subFooter.jsp -->
<%@ include file="/inc/jsp_pl_header.jsp" %>
	<table class="PlFooter" cellpadding="0" cellspacing="0" border="0"><tr>
	<td align="left"><%=com.selectica.render.util.DisplayManager.getIncludeHtml(request, "html/footer.html")%></td>
	<td align="right">
		<a id="poweredByLink" href="http://www.selectica.com" target="_new">
		<img src="pix/meta/poweredby.gif" width="129" height="21" align="right" style="margin:1px 5px 0 0;" alt="Powered by Selectica" />
		</a>
	</td>
	</tr>
	</table>
<div id="blankDiv"></div>
<!-- end inc_dyn_subFooter.jsp -->
<%
%>

<% if (userbean.isNoUserType()) { %><script language="javascript" type="text/javascript">window.onload=function(){setMargin(); }</script><% } %>
