package org.apereo.cas.configuration.model.support.ldap

import java.io.Serializable

/**
 * This is [PrimaryGroupIdSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class PrimaryGroupIdSearchEntryHandlersProperties : Serializable {
    /**
     * The Group filter.
     */
    var groupFilter = "(&(objectClass=group)(objectSid={0}))"
    /**
     * The Base dn.
     */
    var baseDn: String? = null

    companion object {
        private const val serialVersionUID = 539574118704476712L
    }
}
