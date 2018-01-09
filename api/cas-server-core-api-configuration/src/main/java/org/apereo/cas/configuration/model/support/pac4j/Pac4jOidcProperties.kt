package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.util.HashMap

/**
 * This is [Pac4jOidcProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
class Pac4jOidcProperties : Pac4jGenericClientProperties() {
    /**
     * The type of the provider. "google" and "azure" are also acceptable values.
     */
    var type = "generic"
    /**
     * The discovery endpoint to locate the provide metadata.
     */
    @RequiredProperty
    var discoveryUri: String? = null

    /**
     * Whether an initial nonce should be to used
     * initially for replay attack mitigation.
     */
    var isUseNonce: Boolean = false

    /**
     * Requested scope(s).
     */
    var scope: String? = null
    /**
     * The JWS algorithm to use forcefully when validating ID tokens.
     * If none is defined, the first algorithm from metadata will be used.
     */
    var preferredJwsAlgorithm: String? = null

    /**
     * Clock skew in order to account for drift, when validating id tokens.
     */
    var maxClockSkew: Int = 0

    /**
     * Custom parameters to send along in authZ requests, etc.
     */
    var customParams: Map<String, String> = HashMap()

    companion object {
        private val serialVersionUID = 3359382317533639638L
    }
}

