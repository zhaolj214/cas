package org.apereo.cas.configuration.model.support.jdbc

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [SearchJdbcAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-jdbc-authentication")
class SearchJdbcAuthenticationProperties : AbstractJpaProperties() {
    /**
     * Username column name.
     */
    @RequiredProperty
    var fieldUser: String? = null
    /**
     * Password column name.
     */
    @RequiredProperty
    var fieldPassword: String? = null
    /**
     * Table name where accounts are held.
     */
    @RequiredProperty
    var tableUsers: String? = null

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
        private val serialVersionUID = 6912107600297453730L
    }
}
