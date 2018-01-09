package org.apereo.cas.configuration.model.support.scim

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [ScimProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-scim")
class ScimProperties : Serializable {
    /**
     * Indicate what version of the scim protocol is and should be used.
     */
    var version: Long = 2
    /**
     * The SCIM provisioning target URI.
     */
    @RequiredProperty
    var target: String? = null

    /**
     * Authenticate into the SCIM server/service via a pre-generated OAuth token.
     */
    @RequiredProperty
    var oauthToken: String? = null
    /**
     * Authenticate into the SCIM server with a pre-defined username.
     */
    @RequiredProperty
    var username: String? = null
    /**
     * Authenticate into the SCIM server with a pre-defined password.
     */
    @RequiredProperty
    var password: String? = null

    companion object {
        private const val serialVersionUID = 7943229230342691009L
    }
}
