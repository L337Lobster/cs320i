package cs320i


class BootStrap {

    def init = { servletContext ->

        if(User.count() == 0)
        {
            new User(username: 'SamuraiJack365', firstName: 'Jackson', lastName: 'Hofmann', email: 'jazzycool9@gmail.com').save()
            new User(username: 'SamuraiJack365', firstName: 'Jackson', lastName: 'Hofmann', email: 'jazzycool9@gmail.com').save()
            new User(username: 'SamuraiJack365', firstName: 'Jackson', lastName: 'Hofmann', email: 'jazzycool9@gmail.com').save()
        }
    }
    def destroy = {
    }
}
