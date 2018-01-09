package org.apereo.cas.configuration.model.support.hazelcast

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * Encapsulates hazelcast properties exposed by CAS via properties file property source in a type-safe manner.
 *
 * @author Dmitriy Kopylenko
 * @since 4.2.0
 */
@RequiresModule(name = "cas-server-support-hazelcast-ticket-registry")
class HazelcastTicketRegistryProperties : BaseHazelcastProperties() {

    /**
     * Page size is used by a special Predicate which helps to get a page-by-page result of a query.
     */
    var pageSize = 500

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {

        private val serialVersionUID = -1095208036374406772L
    }
}
