package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [Pac4jGenericClientProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
open class Pac4jGenericClientProperties : Serializable {
    /**
     * The client id.
     */
    @RequiredProperty
    var id: String? = null
    /**
     * The client secret.
     */
    @RequiredProperty
    var secret: String? = null
    /**
     * Name of the client mostly for UI purposes and uniqueness.
     */
    var clientName: String? = null

    companion object {
        private const val serialVersionUID = 3007013267786902465L
    }
}
