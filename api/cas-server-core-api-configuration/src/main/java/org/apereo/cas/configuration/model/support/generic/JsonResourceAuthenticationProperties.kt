package org.apereo.cas.configuration.model.support.generic

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PasswordPolicyProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [JsonResourceAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-support-generic")
class JsonResourceAuthenticationProperties : SpringResourceProperties() {
    /**
     * Password policy settings.
     */
    @NestedConfigurationProperty
    var passwordPolicy = PasswordPolicyProperties()

    /**
     * Password encoder properties.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Principal transformation settings for this authentication.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Authentication hanler name used to verify credentials in the file.
     */
    var name: String? = null

    companion object {
        private val serialVersionUID = 1079027841236526083L
    }
}
