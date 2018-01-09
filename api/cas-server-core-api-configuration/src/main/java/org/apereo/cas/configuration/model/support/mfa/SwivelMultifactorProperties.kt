package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

/**
 * This is [SwivelMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-swivel")
class SwivelMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * URL endpoint response to generate a turing image.
     */
    @RequiredProperty
    var swivelTuringImageUrl: String? = null
    /**
     * Swivel endpoint url for verification of credentials.
     */
    @RequiredProperty
    var swivelUrl: String? = null
    /**
     * Shared secret to authenticate against the swivel server.
     */
    @RequiredProperty
    var sharedSecret: String? = null
    /**
     * Control whether SSL errors should be ignored by the swivel server.
     */
    var isIgnoreSslErrors: Boolean = false

    init {
        id = DEFAULT_IDENTIFIER
    }

    companion object {
        /**
         * Provider id by default.
         */
        val DEFAULT_IDENTIFIER = "mfa-swivel"

        private val serialVersionUID = -7409451053833491119L
    }
}
