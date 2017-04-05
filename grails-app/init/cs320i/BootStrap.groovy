package cs320i

import org.springframework.web.context.support.WebApplicationContextUtils

class BootStrap {

    def springSecurityService
//springSecurityService null error fixed with the help of Mat Jones who helped re-write the withTransaction lines
    def init = { servletContext ->
        def adminRole
        def userRole
        Authority.withTransaction {
            adminRole = new Authority(authority: 'ROLE_ADMIN')
            adminRole.save()
            userRole = new Authority(authority: 'ROLE_USER')
            userRole.save()
        }

        def testUser
        Player.withTransaction {
            testUser = new Player(username: 'herp', password: 'derp')
            testUser.springSecurityService = springSecurityService
            testUser.save()
            def auth = testUser.addAuthority('ROLE_ADMIN')
            auth.save()
        }

        assert Player.count() == 1
        assert Authority.count() == 2
        assert PlayerAuthority.count() == 1
    }
    def destroy = {
    }
}
