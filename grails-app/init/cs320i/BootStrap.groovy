package cs320i

import java.sql.Blob
class BootStrap {

    def init = { servletContext ->

        if(User.count() == 0)
        {
            def encrypt = new PasswordEncryptionService()
            def salt = encrypt.generateSalt()
            byte[] encryptedPassword = encrypt.getEncryptedPassword("password", salt)
            Blob storePassword = encrypt.getBlobPassword(encryptedPassword)
            new User(username: 'SamuraiJack365', password: storePassword, firstName: 'Jackson', lastName: 'Hofmann', email: 'jazzycool9@gmail.com').save()
            new User(username: 'SamuraiJack',  password: storePassword, firstName: 'Jason', lastName: 'Hofmann', email: 'jazzy@gmail.com').save()
            new User(username: 'Samurai', password: storePassword, firstName: 'Jack', lastName: 'Hofmann', email: 'cool9@gmail.com').save()
        }
    }
    def destroy = {
    }
}
