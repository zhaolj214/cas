package org.apereo.cas.configuration.model.support.jdbc

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [QueryJdbcAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-jdbc-authentication")
class QueryJdbcAuthenticationProperties : AbstractJpaProperties() {
    /**
     * SQL query to execute. Example: `SELECT * FROM table WHERE name=?`.
     */
    @RequiredProperty
    var sql: String? = null
        set(sql) {
            field = StringUtils.replace(sql, "{user}", "?")
        }
    /**
     * A number of authentication handlers are allowed to determine whether they can operate on the provided credential
     * and as such lend themselves to be tried and tested during the authentication handler selection phase.
     * The credential criteria may be one of the following options:
     *  * 1) A regular expression pattern that is tested against the credential identifier.
     *  * 2) A fully qualified class name of your own design that implements `Predicate<Credential>`.
     *  * 3) Path to an external Groovy script that implements the same interface.
     *
     */
    var credentialCriteria: String? = null
    /**
     * Password field/column name to retrieve.
     */
    @RequiredProperty
    var fieldPassword: String? = null
    /**
     * Boolean field that should indicate whether the account is expired.
     */
    var fieldExpired: String? = null
    /**
     * Boolean field that should indicate whether the account is disabled.
     */
    var fieldDisabled: String? = null
    /**
     * List of column names to fetch as user attributes.
     */
    var principalAttributeList = mutableListOf<String>()

    /**
     * Principal transformation settings for this authentication.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Password encoding strategies for this authentication.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    /**
     * Order of the authentication handler in the chain.
     */
    var order = Integer.MAX_VALUE

    companion object {
        private val serialVersionUID = 7806132208223986680L
    }
}
