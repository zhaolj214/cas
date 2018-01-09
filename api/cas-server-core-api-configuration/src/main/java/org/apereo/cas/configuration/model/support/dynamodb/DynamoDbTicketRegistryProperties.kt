package org.apereo.cas.configuration.model.support.dynamodb

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [DynamoDbTicketRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-dynamodb-ticket-registry")
class DynamoDbTicketRegistryProperties : AbstractDynamoDbProperties() {

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {
        private val serialVersionUID = 699497009058965681L
    }
}
