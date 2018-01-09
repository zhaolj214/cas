package org.apereo.cas.configuration.model.support.rest

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [RestAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-rest-authentication")
class RestAuthenticationProperties : Serializable {
    /**
     * Endpoint URI to use for verification of credentials.
     */
    @RequiredProperty
    var uri: String? = null

    /**
     * Password encoder settings for REST authentication.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = -6122859176355467060L
    }
}
