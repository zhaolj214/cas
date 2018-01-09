package org.apereo.cas.configuration.model.support.trusted

import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * This is [TrustedAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-trusted-webflow")
class TrustedAuthenticationProperties : PersonDirectoryPrincipalResolverProperties() {

    /**
     * Indicates the name of the request header that may be extracted from the request
     * as the indicated authenticated userid from the remote authn system.
     */
    var remotePrincipalHeader: String? = null

    /**
     * Indicates the name of the authentication handler.
     */
    var name: String? = null

    companion object {
        private val serialVersionUID = 279410895614233349L
    }
}
