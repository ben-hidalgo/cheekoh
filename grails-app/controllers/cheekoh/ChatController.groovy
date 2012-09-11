package cheekoh

class ChatController {
    
    def gspToStringService;

    def index() { }
    
    def submit() {
        
        def response = gspToStringService.toString('chat\\submit-comment.gsp', [comment: params.comment]) 
       
        sendMessage('seda:inboundChat', response)
    }
    
    def assign() {
        
        //render (view:'editAjax', model: [])

    }
}
