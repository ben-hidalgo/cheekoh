<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Chat</title>
		<g:javascript library="jquery" />
		<g:javascript src="chat.js" />
		<g:javascript src="purl.js" />
		    

	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		
		<div id="show-chats" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			    <div role="status">${flash.message}</div>
			</g:if>
			<div id="chat-updates" style="margin: 0.8em 1em 0.3em; padding: 0 0.25em"></div>
	    </div>
	    
	    <g:form name="changeRoomForm" method="get">
              
	           Room: <g:textField name="roomName"/>
	           <g:actionSubmit value="Change Room" action="assign"/>

        </g:form>
        
	    <g:formRemote name="myForm" on404="alert('not found!')" update="chat-updates" url="[controller: 'chat', action:'submit']">
               <g:hiddenField name="hiddenRoomName" />
	           Comment: <g:textField name="comment"/>
               <g:submitToRemote update="chat-updates" url="[action:'submit']" value="Post"/> 
        </g:formRemote>


		<script type='text/javascript'>
    		var url = purl();
    		var roomName = url.param('roomName');
    		room.join(roomName);
    		$("#roomName").val(url.param('roomName'));
    		$("#hiddenRoomName").val(url.param('roomName'));
		</script>
	</body>
</html>
