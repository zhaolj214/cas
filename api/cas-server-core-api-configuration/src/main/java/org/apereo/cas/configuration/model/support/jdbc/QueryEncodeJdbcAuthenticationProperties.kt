package org.apereo.cas.configuration.model.support.jdbc

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [QueryEncodeJdbcAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-jdbc-authentication")
class QueryEncodeJdbcAuthenticationProperties : AbstractJpaProperties() {
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
     * Algorithm used for hashing.
     */
    var algorithmName: String? = null
    /**
     * SQL query to execute and look up accounts.
     * Example: `SELECT * FROM table WHERE username=?`.
     */
    @RequiredProperty
    var sql: String? = null

    /**
     * Password column name.
     */
    var passwordFieldName = "password"
    /**
     * Field/column name that indicates the salt used for password hashing.
     */
    @RequiredProperty
    var saltFieldName = "salt"
    /**
     * Column name that indicates whether account is expired.
     */
    var expiredFieldName: String? = null
    /**
     * Column name that indicates whether account is disabled.
     */
    var disabledFieldName: String? = null

    /**
     * Field/column name that indicates the number of iterations used for password hashing.
     */
    var numberOfIterationsFieldName = "numIterations"
    /**
     * Default number of iterations for hashing.
     */
    var numberOfIterations: Long = 0
    /**
     * Static salt to be used for hashing.
     */
    var staticSalt: String? = null

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    /**
     * Order of the authentication handler in the chain.
     */
    var order = Integer.MAX_VALUE

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

    companion object {
        private val serialVersionUID = -6647373426301411768L
    }
}
