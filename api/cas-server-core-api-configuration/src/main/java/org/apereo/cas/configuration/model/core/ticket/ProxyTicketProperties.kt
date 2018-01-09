package org.apereo.cas.configuration.model.core.ticket

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [ProxyTicketProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class ProxyTicketProperties : Serializable {
    /**
     * Number of uses allowed.
     */
    var numberOfUses = 1

    /**
     * Number of seconds after which this ticket becomes invalid.
     */
    var timeToKillInSeconds = 10

    companion object {

        private const val serialVersionUID = -3690545027059561010L
    }
}
