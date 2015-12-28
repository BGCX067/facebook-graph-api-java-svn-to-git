<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- The HTML 4.01 Transitional DOCTYPE declaration-->
<!-- above set at the top of the file will set     -->
<!-- the browser's rendering engine into           -->
<!-- "Quirks Mode". Replacing this declaration     -->
<!-- with a "Standards Mode" doctype is supported, -->
<!-- but may lead to some differences in layout.   -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Facebook Social Graph</title>
  </head>

  <body>
	<center>
    <applet code="com.google.code.facebook.graph.sna.applet.FacebookGraphApplet.class"
            archive="jar/facebookgraph-java-sna.jar"
            width="100%" height="100%">
		<param name="accessToken" value="<%= request.getAttribute("accessToken") %>">
    </applet>
    </center> 
	</body>
</html>
