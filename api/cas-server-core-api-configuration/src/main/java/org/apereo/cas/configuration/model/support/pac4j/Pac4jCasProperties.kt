package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [Pac4jCasProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
class Pac4jCasProperties : Serializable {
    /**
     * The CAS server login url.
     */
    @RequiredProperty
    var loginUrl: String? = null
    /**
     * CAS protocol to use.
     * Acceptable values are `CAS10, CAS20, CAS20_PROXY, CAS30, CAS30_PROXY, SAML`.
     */
    @RequiredProperty
    var protocol: String? = null
    /**
     * Name of the client mostly for UI purposes and uniqueness.
     */
    var clientName: String? = null

    companion object {
        private const val serialVersionUID = -2738631545437677447L
    }
}
