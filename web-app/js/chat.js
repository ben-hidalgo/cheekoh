if (!window.WebSocket) {
    alert("WebSocket not supported by this browser");
}

function $() { return document.getElementById(arguments[0]); }

var room = {
    join: function(name) {
        this._username=name;
        var location = "ws://localhost:9292/"+name;
        this._ws=new WebSocket(location);
        this._ws.onmessage=this._onmessage;
        this._ws.onclose=this._onclose;
    },

    _onmessage: function(m) {
        //alert(m.data)
        
        if (m.data){    
            $('#chat-updates').append(m.data + '<br/>');
        }
    },

    _onclose: function(m) {
        this._ws=null;
    }

};
