package org.apereo.cas.configuration.model.support.mongo.ticketregistry

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.mongo.BaseMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [MongoTicketRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-mongo-ticket-registry")
class MongoTicketRegistryProperties : BaseMongoDbProperties() {

    /**
     * Whether collections should be dropped on startup and re-created.
     */
    var isDropCollection: Boolean = false

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MongoTicketRegistryProperties::class.java)

        private val serialVersionUID = 8243690796900311918L
    }

}
