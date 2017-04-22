package cs320i

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Player implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService
	transient bEncoded

	String username
	String password
    String firstName, lastName, email
	static hasOne = [calendar: MyCalendar]
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired


	static transients = ['springSecurityService', 'bEncoded']

	Set<Authority> getAuthorities() {
		PlayerAuthority.findAllByPlayer(this)*.authority
	}

	def addAuthority(String role){
		Authority auth = Authority.findByAuthority(role)
		if(auth && !getAuthorities().contains(auth)) PlayerAuthority.create(this, auth)
	}

	def beforeInsert() {
//		println(SpringSecurityService.encodePassword("derp"))
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}
	protected void encodePassword() {
		if(!bEncoded){
			password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
			bEncoded = springSecurityService?.passwordEncoder ? true : false
		}
	}

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}
}
