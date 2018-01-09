package org.apereo.cas.configuration.model.support.cookie

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * Configuration properties class for tgc.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-cookie", automated = true)
class TicketGrantingCookieProperties : CookieProperties() {
    /**
     * If remember-me is enabled, specifies the maximum age of the cookie.
     */
    private var rememberMeMaxAge = "P14D"

    /**
     * Crypto settings that determine how the cookie should be signed and encrypted.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    init {
        super.name = "TGC"
    }

    fun getRememberMeMaxAge(): Long {
        return Beans.newDuration(rememberMeMaxAge).seconds
    }

    fun setRememberMeMaxAge(rememberMeMaxAge: String) {
        this.rememberMeMaxAge = rememberMeMaxAge
    }

    companion object {

        private val serialVersionUID = 7392972818105536350L
    }

}
