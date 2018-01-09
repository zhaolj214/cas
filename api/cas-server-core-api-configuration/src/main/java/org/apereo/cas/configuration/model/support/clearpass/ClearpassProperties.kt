package org.apereo.cas.configuration.model.support.clearpass

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [ClearpassProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class ClearpassProperties : Serializable {
    /**
     * Enable clearpass and allow CAS to cache credentials.
     */
    var isCacheCredential: Boolean = false

    /**
     * Crypto settings that sign/encrypt the password captured.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    companion object {
        private const val serialVersionUID = 6047778458053531460L
    }
}
