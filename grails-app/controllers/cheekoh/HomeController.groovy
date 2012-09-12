package cheekoh

class HomeController {

    def index() { 
        [popularRooms: 
            [
                [displayName: 'Ex Wy Ze', roomName: 'xyz'], 
                [displayName: 'Ay Be Se', roomName: 'abc']
            ]
        ]
    }
}
