package cs320i


class BootStrap {

    def init = { servletContext ->
        def springSecurityService
        def adminRole = new Authority(authority: 'ROLE_ADMIN').save()
        def userRole = new Authority(authority: 'ROLE_USER').save()

        def testUser = new Player(username: 'herp', password: 'derp').save()
        PlayerAuthority.create testUser, adminRole

        PlayerAuthority.withSession {
            it.flush()
            it.clear()
        }

        assert Player.count() == 1
        assert Authority.count() == 2
        assert PlayerAuthority.count() == 1
    }
    def destroy = {
    }
}
