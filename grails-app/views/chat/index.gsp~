<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Chat</title>
		<g:javascript library="jquery" />
		    
		<script type='text/javascript'>

        if (!window.WebSocket) {
	        alert("WebSocket not supported by this browser");
        }

        function $() { return document.getElementById(arguments[0]); }

        var room = {
	        join: function(name) {
		        this._username=name;
		        var location = "ws://localhost:9292/chat";
		        this._ws=new WebSocket(location);
		        this._ws.onmessage=this._onmessage;
		        this._ws.onclose=this._onclose;
	        },

	        _onmessage: function(m) {
		        //alert(m.data)
	        	
		        if (m.data){
		        	$('#chat-updates').append('<span>'+m.data+'</span><br/>');
		        }
	        },

	        _onclose: function(m) {
		        this._ws=null;
	        }

        };

    </script>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:remoteLink class="" controller="chat" action="submit" update="chat-updates">Submit</g:remoteLink></li>
			</ul>
		</div>
		
		<div id="show-chats" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			    <div role="status">${flash.message}</div>
			</g:if>
			<div id="chat-updates" style="margin: 0.8em 1em 0.3em; padding: 0 0.25em"></div>
	    </div>

		<script type='text/javascript'>
    		room.join("Testing");
		</script>
	</body>
</html>
