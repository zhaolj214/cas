package org.apereo.cas.configuration.model.core.ticket

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [ServiceTicketProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class ServiceTicketProperties : Serializable {
    /**
     * Controls number of times a service ticket can be used within CAS server. Usage in CAS context means service ticket validation
     * transaction.
     */
    var numberOfUses = 1

    /**
     * Time in seconds that service tickets should be considered live in CAS server.
     */
    var timeToKillInSeconds: Long = 10

    /**
     * Maximum length of generated service tickets.
     */
    var maxLength = 20

    companion object {

        private const val serialVersionUID = -7445209580598499921L
    }
}
