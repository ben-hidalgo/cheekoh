package cheekoh

class ChatController {

    def index() { }
    
    def submit() {
    
       def builder = new groovy.json.JsonBuilder()
       def root = builder.people {
           person {
               firstName new Date()
               lastName params.comment
               // Named arguments are valid values for objects too
               address(
                       city: 'Paris',
                       country: 'France',
                       zip: 12345,
               )
               married true
               // a list of values
               conferences 'JavaOne', 'Gr8conf'
           }
       }
       
        sendMessage('seda:inboundChat', builder.toString())
    }
}
