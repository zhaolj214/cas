package org.apereo.cas.configuration.model.support.ldap

import org.apereo.cas.configuration.support.RequiredProperty

/**
 * This is [AbstractLdapSearchProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
abstract class AbstractLdapSearchProperties : AbstractLdapProperties() {

    /**
     * Whether subtree searching is allowed.
     */
    var isSubtreeSearch = true

    /**
     * Base DN to use.
     */
    @RequiredProperty
    var baseDn: String? = null

    /**
     * User filter to use for searching.
     * Syntax is `cn={user}` or `cn={0}`.
     */
    @RequiredProperty
    open var searchFilter: String? = null

    companion object {
        private val serialVersionUID = 3009946735155362639L
    }
}
