package org.apereo.cas.configuration.model.support.generic

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.util.HashSet

/**
 * Configuration properties class for shiro.authn.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-shiro")
class ShiroAuthenticationProperties : SpringResourceProperties() {
    /**
     * Required roles that should be authorized by Shiro.
     */
    var requiredRoles: Set<String> = HashSet()
    /**
     * Required permissions that should be authorized by Shiro.
     */
    var requiredPermissions: Set<String> = HashSet()

    /**
     * Password encoder properties.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private val serialVersionUID = 8997401036330472417L
    }
}
