package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

/**
 * This is [DuoSecurityMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-duo")
class DuoSecurityMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * Duo integration key.
     */
    @RequiredProperty
    var duoIntegrationKey: String? = null
    /**
     * Duo secret key.
     */
    @RequiredProperty
    var duoSecretKey: String? = null
    /**
     * The duoApplicationKey is a string, at least 40 characters long,
     * that you generate and keep secret from Duo.
     * You can generate a random string in Python with:
     * <pre>
     * import os, hashlib
     * print hashlib.sha1(os.urandom(32)).hexdigest()
    </pre> *
     */
    @RequiredProperty
    var duoApplicationKey: String? = null
    /**
     * Duo API host and url.
     */
    @RequiredProperty
    var duoApiHost: String? = null

    /**
     * Link to a registration app, typically developed in-house
     * in order to allow new users to sign-up for duo functionality.
     * If the user account status requires enrollment and this link
     * is specified, CAS will redirect the authentication flow
     * to this registration app. Otherwise, the default duo mechanism
     * for new-user registrations shall take over.
     */
    var registrationUrl: String? = null
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
        val DEFAULT_IDENTIFIER = "mfa-duo"

        private val serialVersionUID = -4655375354167880807L
    }
}
