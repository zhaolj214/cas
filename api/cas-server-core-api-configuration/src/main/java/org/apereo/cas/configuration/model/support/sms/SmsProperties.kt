package org.apereo.cas.configuration.model.support.sms

import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [SmsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
class SmsProperties : Serializable {
    /**
     * The body of the SMS message.
     */
    @RequiredProperty
    var text: String? = null
    /**
     * The from address for the message.
     */
    @RequiredProperty
    var from: String? = null

    /**
     * Principal attribute name that indicates the destination phone number
     * for this SMS message. The attribute must already be resolved and available
     * to the CAS principal.
     */
    @RequiredProperty
    var attributeName = "phone"

    companion object {

        private const val serialVersionUID = -3713886839517507306L
    }
}
