package cs320i

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

        def calendar = new MyCalendar()
        def testUser
        Player.withTransaction {
            testUser = new Player(username: 'SamuraiJack365', password: 'derp', firstName: 'Jackson', lastName: 'Hofmann', email: 'jazzycool9@gmail.com', calendar: calendar)
            testUser.springSecurityService = springSecurityService
            testUser.save()
            testUser.addAuthority('ROLE_USER')
            def auth = testUser.addAuthority('ROLE_ADMIN')
            auth.save()
        }

        assert Player.count() == 1
        assert Authority.count() == 2
        assert PlayerAuthority.count() == 2
    }
    def destroy = {
    }
}
