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
    <title>Add a keyword for a url here.</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
  </head>

  <body>
  	<%
  		String key = request.getParameter("k");
  		if (key == null) {
  			key = "";
   	%>
  			<script type="text/javascript">
    			$(document).ready(function() {
    				$("#key").focus();
    			});
    		</script>
  	<%	} else { %>
  			<script type="text/javascript">
    			$(document).ready(function() {
    				$("#url").focus();
    			});
    		</script>
  	<%	}
  	%>
  	<form action = "/add" type="post">
  		Key <input type = "text" name="key" id="key" value="<%=key%>" /> <br>
  		Url <input type = "text" name="url" id="url" /> <br>
  		<input type="submit" value="Submit">
  	</form>
  </body>
</html>
