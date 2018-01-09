package org.apereo.cas.configuration.model.core.ticket

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [ProxyGrantingTicketProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class ProxyGrantingTicketProperties : Serializable {
    /**
     * Maximum length of the proxy granting ticket, when generating one.
     */
    var maxLength = 50

    companion object {
        private const val serialVersionUID = 8478961497316814687L
    }
}
