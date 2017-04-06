package cs320i

import grails.plugin.springsecurity.annotation.Secured

class JhofmannController {

    def index() { }

    def home()
    {
        render (view:'index.gsp')
    }

    @Secured('ROLE_USER')
    def self()
    {
        String username = getPrincipal().username
        def self = Player.findByUsername(username)
        [self:self]
    }
    @Secured('ROLE_USER')
    def players() {

       def users = Player.list()
        [users:users]
    }

}
