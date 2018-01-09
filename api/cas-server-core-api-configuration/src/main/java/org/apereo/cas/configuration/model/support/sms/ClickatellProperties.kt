package org.apereo.cas.configuration.model.support.sms

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [ClickatellProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-sms-clickatell")
class ClickatellProperties : Serializable {
    /**
     * Secure token used to establish a handshake with the service.
     */
    @RequiredProperty
    var token: String? = null
    /**
     * URL to contact and send messages.
     */
    @RequiredProperty
    var serverUrl = "https://platform.clickatell.com/messages"

    companion object {
        private const val serialVersionUID = -2147844690349952176L
    }
}
