package org.apereo.cas.configuration.model.support.email

import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [EmailProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class EmailProperties : Serializable {
    /**
     * Principal attribute name that indicates the destination email address
     * for this message. The attribute must already be resolved and available
     * to the CAS principal.
     */
    @RequiredProperty
    var attributeName = "mail"

    /**
     * Email message body.
     */
    var text: String? = null

    /**
     * Email from address.
     */
    @RequiredProperty
    var from: String? = null

    /**
     * Email subject line.
     */
    @RequiredProperty
    var subject: String? = null

    /**
     * Email CC address, if any.
     */
    var cc: String? = null

    /**
     * Email BCC address, if any.
     */
    var bcc: String? = null

    companion object {

        private const val serialVersionUID = 7367120636536230761L
    }
}
