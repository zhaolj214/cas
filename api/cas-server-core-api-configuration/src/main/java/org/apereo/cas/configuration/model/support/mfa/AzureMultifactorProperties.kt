package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule

/**
 * This is [AzureMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-azure")
class AzureMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * The functionality of Azure depends on the availability of a phone number that is
     * resolved as a pre-defined attribute for the CAS principal. This is where
     * you define that attribute.
     */
    @RequiredProperty
    var phoneAttributeName = "phone"
    /**
     * Your Microsoft Azure subscription will provide you with a license and a client certificate.
     * The client certificate is a unique private certificate that was generated especially for you.
     * These configuration files are to be placed in a directory whose path is then taught to CAS here.
     */
    @RequiredProperty
    var configDir: String? = null
    /**
     * Password to the private key provided to you by Microsoft.
     */
    @RequiredProperty
    var privateKeyPassword: String? = null
    /**
     * Available authentication modes supported by CAS and Azure.
     */
    var mode = AuthenticationModes.POUND
    /**
     * Whether Azure should be allowed to make international calls.
     */
    var isAllowInternationalCalls: Boolean = false

    /**
     * The authentication modes supported by Azure.
     */
    enum class AuthenticationModes {
        /**
         * Ask the user to only press the pound sign.
         */
        POUND,
        /**
         * Ask the user to enter pin code shown on the screen.
         */
        PIN
    }

    init {
        id = DEFAULT_IDENTIFIER
    }

    companion object {

        /**
         * Provider id by default.
         */
        const val DEFAULT_IDENTIFIER = "mfa-azure"

        private val serialVersionUID = 6726032660671158922L
    }
}
