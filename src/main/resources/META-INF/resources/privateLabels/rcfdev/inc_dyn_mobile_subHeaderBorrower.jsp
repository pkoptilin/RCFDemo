	    <script language="JavaScript" type="text/javascript" src="js/mobile.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/touch-1.1.0/sencha-touch-debug.js"></script>
		<script language="JavaScript" type="text/javascript" src="js/idroid.js"></script>

		<link rel="stylesheet" href="js/touch-1.1.0/resources/css-debug/sencha-touch-sel.css" type="text/css">
	    <link rel="stylesheet" href="styles/mobile.css" media="screen" />
<style type="text/css">.PublicFaqFooter{display:none}</style>
</head>
<body>
<%=com.selectica.render.util.DisplayManager.getFailOverMessage(request)%>
<div id="north">
<%=com.selectica.render.util.DisplayManager.getIncludeHtml(request, "html/header.html")%>
<%= navbean.getHelpPopupHTML()%>
