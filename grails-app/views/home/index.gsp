<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Home</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		
		<div>
			<ul>
			    <li><g:link class="list" controller="chat" action="index" params="[roomName: 'xyz']">Chat</g:link></li>
			    <g:each in="${popularRooms}" > 
			        <li><g:link class="list" controller="chat" action="index" params="[roomName: "${it.roomName}"]">${it.displayName}</g:link></li>
			    </g:each>
				
			</ul>
		</div>
		
		

	</body>
</html>
