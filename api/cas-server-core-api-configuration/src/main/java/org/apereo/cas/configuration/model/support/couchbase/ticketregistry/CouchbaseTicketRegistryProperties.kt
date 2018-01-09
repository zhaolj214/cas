package org.apereo.cas.configuration.model.support.couchbase.ticketregistry

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.couchbase.BaseCouchbaseProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [CouchbaseTicketRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-couchbase-ticket-registry")
class CouchbaseTicketRegistryProperties : BaseCouchbaseProperties() {

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {
        private val serialVersionUID = 2123040809519673836L
    }
}
