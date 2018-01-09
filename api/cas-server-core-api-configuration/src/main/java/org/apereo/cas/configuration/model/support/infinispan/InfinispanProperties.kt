package org.apereo.cas.configuration.model.support.infinispan

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * Encapsulates hazelcast properties exposed by CAS via properties file property source in a type-safe manner.
 *
 * @author Dmitriy Kopylenko
 * @since 4.2.0
 */
@RequiresModule(name = "cas-server-support-infinispan-ticket-registry")
class InfinispanProperties : Serializable {
    /**
     * Path to the infinispan XML configuration file.
     */
    @RequiredProperty
    var configLocation: Resource = ClassPathResource("infinispan.xml")
    /**
     * Cache name to create and hold tickets in.
     */
    @RequiredProperty
    var cacheName: String? = null

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {

        private const val serialVersionUID = 1974626726565626634L
    }
}
