package cs320i

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Player implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService = new SpringSecurityService()

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Set<Authority> getAuthorities() {
		PlayerAuthority.findAllByPlayer(this)*.authority
	}

	def beforeInsert() {
		println(SpringSecurityService.encodePassword("derp"))
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}
	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}
}
