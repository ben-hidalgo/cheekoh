

import org.apache.camel.builder.RouteBuilder

class ChatRoute extends RouteBuilder {
	def grailsApplication

    @Override
    void configure() {
		def config = grailsApplication?.config
		
		from('seda:inboundChat').to('websocket:chat?sendToAll=true')
		//from('seda:inboundChat').to('stream:out')
        
		// example:
        // from('seda:input').to('stream:out')
    }
}
