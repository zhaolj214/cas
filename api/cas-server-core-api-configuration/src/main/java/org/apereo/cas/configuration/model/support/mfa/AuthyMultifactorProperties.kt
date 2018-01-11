package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule

/**
 * This is [AuthyMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-authy")
class AuthyMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * Authy API key.
     */
    @RequiredProperty
    var apiKey: String? = null
    /**
     * Authy API url.
     */
    @RequiredProperty
    var apiUrl: String? = null
    /**
     * Principal attribute used to look up a phone number
     * for credential verification. The attribute value
     * is then used to look up the user record in Authy, or
     * create the user.
     */
    @RequiredProperty
    var phoneAttribute = "phone"

    /**
     * Principal attribute used to look up an email address
     * for credential verification. The attribute value
     * is then used to look up the user record in Authy, or
     * create the user.
     */
    @RequiredProperty
    var mailAttribute = "mail"

    /**
     * Phone number country code used to look up and/or create the Authy user account.
     */
    var countryCode = "1"
    /**
     * Flag authentication requests to authy to force verification of credentials.
     */
    var isForceVerification = true

    /**
     * Indicates whether this provider should support trusted devices.
     */
    var isTrustedDeviceEnabled: Boolean = false

    init {
        id = DEFAULT_IDENTIFIER
    }

    companion object {
        /**
         * Provider id by default.
         */
        const val DEFAULT_IDENTIFIER = "mfa-authy"

        private val serialVersionUID = -3746749663459157641L
    }
}
