package org.apereo.cas.configuration.model.support.ldap

import org.apache.commons.lang3.StringUtils

import java.io.Serializable

/**
 * This is [LdapAuthorizationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */

class LdapAuthorizationProperties : Serializable {

    /**
     * Attribute expected to be found on the entry whose value is going to be used to
     * construct roles. The final value is always prefixed with [.rolePrefix].
     * This is useful in scenarios where you wish to grant access to a resource to all
     * users who carry a special attribute.
     */
    var roleAttribute = "uugid"

    /**
     * Prefix for the role.
     */
    var rolePrefix = DEFAULT_ROLE_PREFIX

    /**
     * Indicate whether the LDAP search query is allowed to return multiple entries.
     */
    var isAllowMultipleResults: Boolean = false

    /**
     * Attribute expected to be found on the entry resulting from the group search whose value is going to be used to
     * construct roles. The final value is always prefixed with [.groupPrefix].
     * This is useful in scenarios where you wish to grant access to a resource to all
     * users who a member of a given group.
     */
    var groupAttribute: String? = null

    /**
     * A prefix that is prepended to the group attribute value to construct an authorized role.
     */
    var groupPrefix = StringUtils.EMPTY

    /**
     * Search filter to begin looking for groups.
     */
    var groupFilter: String? = null

    /**
     * Base DN to start the search looking for groups.
     */
    var groupBaseDn: String? = null
        get() = StringUtils.defaultIfBlank<String>(field, this.baseDn)

    /**
     * Base DN to start the search.
     */
    var baseDn: String? = null
    /**
     * LDAP search filter to locate accounts.
     */
    var searchFilter: String? = null

    companion object {
        /**
         * Default role prefix.
         */
        val DEFAULT_ROLE_PREFIX = "ROLE_"
        private const val serialVersionUID = -2680169790567609780L
    }
}
