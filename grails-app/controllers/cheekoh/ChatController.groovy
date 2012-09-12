package cheekoh

import org.apache.camel.builder.RouteBuilder

class ChatController {
    
    def gspToStringService;
    def camelContext


    
    def index() { 
    
        def routeExists = false
        log.debug "index() request=${request}"
        for(org.apache.camel.Route route : camelContext.routes) {
            log.debug("index() route.endpoint.endpointUri=${route.endpoint.endpointUri}")
            //def s1 = 
            if(route.endpoint.endpointUri.equals('seda://inbound'+params.roomName))  {
                log.debug "setting routeExists true"
                routeExists = true
                break
            }
        }
        
        
        if (!routeExists) {
            camelContext.addRoutes(new RouteBuilder() {
                @Override void configure() {
                    from("seda:inbound${params.roomName}").to("websocket:${params.roomName}?sendToAll=true")
                }
            });
        }
    }
    
    def submit() {
        
        log.debug "submit() request=    ${request.parameterMap}"
        
        def response = gspToStringService.toString('chat\\submit-comment.gsp', [comment: params.comment]) 
       
        sendMessage('seda:inbound'+params.hiddenRoomName, response)
    }
    
    def assign() {
        
        redirect (action: 'index', params: [roomName: params.roomName])
        
        //render (view:'editAjax', model: [])

    }
}
