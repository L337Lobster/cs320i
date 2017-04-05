package cs320i

import grails.plugin.springsecurity.annotation.Secured

class JhofmannController {

    def index() { }

    def home()
    {
        render (view:'index.gsp')
    }

    def self()
    {
        def self = Player.findByUsername("SamuraiJack365")
        [self:self]
    }

    def players() {

       def users = Player.list()
        [users:users]
    }

}
