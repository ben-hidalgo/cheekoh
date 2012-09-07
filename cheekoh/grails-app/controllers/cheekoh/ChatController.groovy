package cheekoh

class ChatController {

    def index() { }
    
    def submit() {
    
        sendMessage('seda:inboundChat', 'hi')
    }
}
