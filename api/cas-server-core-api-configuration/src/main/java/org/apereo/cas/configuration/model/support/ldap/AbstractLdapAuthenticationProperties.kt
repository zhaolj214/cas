package org.apereo.cas.configuration.model.support.ldap

import org.apereo.cas.configuration.support.RequiredProperty

import java.util.ArrayList

/**
 * This is [AbstractLdapAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
abstract class AbstractLdapAuthenticationProperties : AbstractLdapSearchProperties() {

    /**
     * The authentication type.
     *
     *  * AD - Users authenticate with sAMAccountName.
     *  * AUTHENTICATED - Manager bind/search
     *  * ANONYMOUS
     *  * DIRECT: Direct Bind - Compute user DN from format string and perform simple bind.
     * This is relevant when no search is required to compute the DN needed for a bind operation.
     * Use cases for this type are:
     * 1) All users are under a single branch in the directory, `e.g. ou=Users,dc=example,dc=org.`
     * 2) The username provided on the CAS login form is part of the DN, e.g.
     * `uid=%s,ou=Users,dc=example,dc=org`.
     *
     */
    @RequiredProperty
    var type: AuthenticationTypes? = null

    /**
     * If principalAttributePassword is empty then a user simple bind is done to validate credentials
     * otherwise the given attribute is compared with the given principalAttributePassword
     * using the SHA encrypted value of it.
     *
     *
     * For the anonymous authentication type,
     * if principalAttributePassword is empty then a user simple bind is done to validate credentials
     * otherwise the given attribute is compared with the given principalAttributePassword
     * using the SHA encrypted value of it.
     *
     */
    var principalAttributePassword: String? = null

    /**
     * Specify the dn format accepted by the AD authenticator, etc.
     * Example format might be `uid=%s,ou=people,dc=example,dc=org`.
     */
    var dnFormat: String? = null

    /**
     * Whether specific search entry resolvers need to be set
     * on the authenticator, or the default should be used.
     */
    var isEnhanceWithEntryResolver = true


    /**
     * Define how aliases are de-referenced.
     * Accepted values are:
     *
     *  * `NEVER`
     *  * `SEARCHING`: dereference when searching the entries beneath the starting point but not when searching for the starting entry.
     *  * `FINDING`: dereference when searching for the starting entry but not when searching the entries beneath the starting point.
     *  * `ALWAYS`: dereference when searching for the starting entry and when searching the entries beneath the starting point.
     *
     */
    var derefAliases: String? = null

    /**
     * Search entry to define on the authenticator.
     */
    var searchEntryHandlers: List<LdapSearchEntryHandlersProperties> = ArrayList()

    /**
     * The enum Authentication types.
     */
    enum class AuthenticationTypes {
        /**
         * Active Directory.
         */
        AD,
        /**
         * Authenticated Search.
         */
        AUTHENTICATED,
        /**
         * Direct Bind.
         */
        DIRECT,
        /**
         * Anonymous Search.
         */
        ANONYMOUS
    }

    companion object {

        private val serialVersionUID = 3849857270054289852L
    }
}
