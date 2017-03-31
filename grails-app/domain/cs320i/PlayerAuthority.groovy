package cs320i

import grails.gorm.DetachedCriteria
import groovy.transform.ToString

import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class PlayerAuthority implements Serializable {

	private static final long serialVersionUID = 1

	Player player
	Authority authority

	@Override
	boolean equals(other) {
		if (other instanceof PlayerAuthority) {
			other.playerId == player?.id && other.authorityId == authority?.id
		}
	}

	@Override
	int hashCode() {
		def builder = new HashCodeBuilder()
		if (player) builder.append(player.id)
		if (authority) builder.append(authority.id)
		builder.toHashCode()
	}

	static PlayerAuthority get(long playerId, long authorityId) {
		criteriaFor(playerId, authorityId).get()
	}

	static boolean exists(long playerId, long authorityId) {
		criteriaFor(playerId, authorityId).count()
	}

	private static DetachedCriteria criteriaFor(long playerId, long authorityId) {
		PlayerAuthority.where {
			player == Player.load(playerId) &&
			authority == Authority.load(authorityId)
		}
	}

	static PlayerAuthority create(Player player, Authority authority) {
		def instance = new PlayerAuthority(player: player, authority: authority)
		instance.save()
		instance
	}

	static boolean remove(Player u, Authority r) {
		if (u != null && r != null) {
			PlayerAuthority.where { player == u && authority == r }.deleteAll()
		}
	}

	static int removeAll(Player u) {
		u == null ? 0 : PlayerAuthority.where { player == u }.deleteAll()
	}

	static int removeAll(Authority r) {
		r == null ? 0 : PlayerAuthority.where { authority == r }.deleteAll()
	}

	static constraints = {
		authority validator: { Authority r, PlayerAuthority ur ->
			if (ur.player?.id) {
				PlayerAuthority.withNewSession {
					if (PlayerAuthority.exists(ur.player.id, r.id)) {
						return ['userRole.exists']
					}
				}
			}
		}
	}

	static mapping = {
		id composite: ['player', 'authority']
		version false
	}
}
