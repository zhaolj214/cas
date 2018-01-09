package org.apereo.cas.configuration.model.support.sms

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [TwilioProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-sms-twilio")
class TwilioProperties : Serializable {
    /**
     * Twilio account identifier used for authentication.
     */
    @RequiredProperty
    var accountId: String? = null

    /**
     * Twilio secret token used for authentication.
     */
    @RequiredProperty
    var token: String? = null

    companion object {
        private const val serialVersionUID = -7043132225482495229L
    }
}
