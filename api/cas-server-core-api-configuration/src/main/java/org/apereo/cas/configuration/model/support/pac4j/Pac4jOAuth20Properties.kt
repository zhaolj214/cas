package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

/**
 * This is [Pac4jOAuth20Properties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
class Pac4jOAuth20Properties : Pac4jGenericClientProperties() {
    /**
     * Authorization endpoint of the provider.
     */
    @RequiredProperty
    var authUrl: String? = null
    /**
     * Token endpoint of the provider.
     */
    @RequiredProperty
    var tokenUrl: String? = null
    /**
     * Profile endpoint of the provider.
     */
    @RequiredProperty
    var profileUrl: String? = null
    /**
     * Profile path portion of the profile endpoint of the provider.
     */
    var profilePath: String? = null
    /**
     * Http method to use when asking for profile.
     */
    var profileVerb = "POST"

    /**
     * Profile attributes to request and collect in form of key-value pairs.
     */
    var profileAttrs: Map<String, String>? = null

    /**
     * Custsom parameters in form of key-value pairs sent along in authZ requests, etc.
     */
    var customParams: Map<String, String>? = null

    companion object {
        private val serialVersionUID = -1240711580664148382L
    }

}

