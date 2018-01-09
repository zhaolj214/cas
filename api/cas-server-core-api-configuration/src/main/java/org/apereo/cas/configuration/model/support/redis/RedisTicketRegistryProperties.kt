package org.apereo.cas.configuration.model.support.redis

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * Configuration properties for Redis.
 *
 * @author serv
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-redis-ticket-registry")
class RedisTicketRegistryProperties : BaseRedisProperties() {

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {
        private val serialVersionUID = -2600996050439638782L
    }

}
