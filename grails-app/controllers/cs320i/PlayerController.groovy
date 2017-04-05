package cs320i

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured('ROLE_ADMIN')
@Transactional(readOnly = true)
class PlayerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Player.list(params), model:[playerCount: Player.count()]
    }

    def show(Player player) {
        respond player
    }

    def create() {
        respond new Player(params)
    }

    @Transactional
    def save(Player player) {
        if (player == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (player.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond player.errors, view:'create'
            return
        }

        player.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'player.label', default: 'Player'), player.id])
                redirect player
            }
            '*' { respond player, [status: CREATED] }
        }
    }

    def edit(Player player) {
        respond player
    }

    @Transactional
    def update(Player player) {
        if (player == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (player.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond player.errors, view:'edit'
            return
        }

        player.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'player.label', default: 'Player'), player.id])
                redirect player
            }
            '*'{ respond player, [status: OK] }
        }
    }

    @Transactional
    def delete(Player player) {

        if (player == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        player.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'player.label', default: 'Player'), player.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'player.label', default: 'Player'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
