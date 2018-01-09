package org.apereo.cas.configuration.model.core.util

import org.apereo.cas.configuration.model.core.ticket.ProxyGrantingTicketProperties
import org.apereo.cas.configuration.model.core.ticket.ProxyTicketProperties
import org.apereo.cas.configuration.model.core.ticket.ServiceTicketProperties
import org.apereo.cas.configuration.model.core.ticket.TicketGrantingTicketProperties
import org.apereo.cas.configuration.model.core.ticket.registry.TicketRegistryProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * Configuration properties class for `ticket`.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class TicketProperties : Serializable {
    /**
     * Properties and settings related to proxy-granting tickets.
     */
    @NestedConfigurationProperty
    var pgt = ProxyGrantingTicketProperties()

    /**
     * Properties and settings related to ticket encryption.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    /**
     * Properties and settings related to proxy tickets.
     */
    @NestedConfigurationProperty
    var pt = ProxyTicketProperties()

    /**
     * Properties and settings related to ticket registry.
     */
    @NestedConfigurationProperty
    var registry = TicketRegistryProperties()

    /**
     * Properties and settings related to service tickets.
     */
    @NestedConfigurationProperty
    var st = ServiceTicketProperties()

    /**
     * Properties and settings related to ticket-granting tickets.
     */
    @NestedConfigurationProperty
    var tgt = TicketGrantingTicketProperties()

    init {
        this.crypto.isEnabled = false
    }

    companion object {

        private const val serialVersionUID = 5586947805593202037L
    }
}
