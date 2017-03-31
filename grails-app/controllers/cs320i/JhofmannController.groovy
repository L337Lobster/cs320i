package cs320i

class JhofmannController {

    def index() { }

    def home()
    {
        render (view:'index.gsp')
    }

    def self()
    {
        /*def self = User.findByUsername("SamuraiJack365")
        [self:self]*/
    }

    def players() {

       /* def users = User.list()
        [users:users]*/
    }

}
