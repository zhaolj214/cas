package org.apereo.cas.configuration.model.support.generic

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [RejectAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-generic")
class RejectAuthenticationProperties : Serializable {
    /**
     * Comma-separated list of users to reject for authentication.
     */
    var users: String? = null

    /**
     * Password encoder properties.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * This is principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = -3228601837221178711L
    }
}
