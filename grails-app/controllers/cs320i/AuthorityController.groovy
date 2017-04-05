package cs320i

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class AuthorityController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Authority.list(params), model:[authorityCount: Authority.count()]
    }

    def show(Authority authority) {
        respond authority
    }

    def create() {
        respond new Authority(params)
    }

    @Transactional
    def save(Authority authority) {
        if (authority == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (authority.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond authority.errors, view:'create'
            return
        }

        authority.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'authority.label', default: 'Authority'), authority.id])
                redirect authority
            }
            '*' { respond authority, [status: CREATED] }
        }
    }

    def edit(Authority authority) {
        respond authority
    }

    @Transactional
    def update(Authority authority) {
        if (authority == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (authority.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond authority.errors, view:'edit'
            return
        }

        authority.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'authority.label', default: 'Authority'), authority.id])
                redirect authority
            }
            '*'{ respond authority, [status: OK] }
        }
    }

    @Transactional
    def delete(Authority authority) {

        if (authority == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        authority.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'authority.label', default: 'Authority'), authority.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'authority.label', default: 'Authority'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
