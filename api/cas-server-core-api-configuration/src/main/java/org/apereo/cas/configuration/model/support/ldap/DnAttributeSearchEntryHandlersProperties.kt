package org.apereo.cas.configuration.model.support.ldap

import java.io.Serializable

/**
 * This is [DnAttributeSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class DnAttributeSearchEntryHandlersProperties : Serializable {
    /**
     * The Dn attribute name.
     */
    var dnAttributeName = "entryDN"
    /**
     * The Add if exists.
     */
    var isAddIfExists: Boolean = false

    companion object {
        private const val serialVersionUID = -1174594647679213858L
    }
}
