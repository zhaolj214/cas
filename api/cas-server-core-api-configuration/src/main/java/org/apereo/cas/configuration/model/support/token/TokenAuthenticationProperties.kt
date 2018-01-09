package org.apereo.cas.configuration.model.support.token

import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.core.util.EncryptionOptionalSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [TokenAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-token-webflow")
class TokenAuthenticationProperties : Serializable {
    /**
     * Principal transformation settings.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Crypto settings.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionOptionalSigningJwtCryptographyProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = 6016124091895278265L
    }
}
