package org.apereo.cas.configuration.model.support.syncope

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [SyncopeAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-support-syncope-authentication")
class SyncopeAuthenticationProperties : Serializable {

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    /**
     * Syncope domain used for authentication, etc.
     */
    var domain = "Master"

    /**
     * Syncope instance URL primary used for REST.
     */
    @RequiredProperty
    var url: String? = null

    /**
     * Password encoder settings for the authentication handler.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

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
     * This is principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    companion object {
        private const val serialVersionUID = -2446926316502297496L
    }
}
