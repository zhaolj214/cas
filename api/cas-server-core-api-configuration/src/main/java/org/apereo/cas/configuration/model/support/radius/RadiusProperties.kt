package org.apereo.cas.configuration.model.support.radius

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [RadiusProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-radius")
class RadiusProperties : Serializable {
    /**
     * Whether catastrophic errors should be skipped
     * and fail over to the next server.
     */
    var isFailoverOnException: Boolean = false

    /**
     * Whether authentication errors should be skipped
     * and fail over to the next server.
     */
    var isFailoverOnAuthenticationFailure: Boolean = false

    /**
     * RADIUS server settings.
     */
    @NestedConfigurationProperty
    var server = RadiusServerProperties()

    /**
     * RADIUS client settings.
     */
    @NestedConfigurationProperty
    var client = RadiusClientProperties()

    /**
     * Password encoder settings.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Principal transoformation settings.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * The name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = 5244307919878753714L
    }
}
