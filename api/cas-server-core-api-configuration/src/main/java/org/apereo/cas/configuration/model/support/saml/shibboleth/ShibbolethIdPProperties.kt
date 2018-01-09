package org.apereo.cas.configuration.model.support.saml.shibboleth

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [ShibbolethIdPProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-shibboleth")
class ShibbolethIdPProperties : Serializable {
    /**
     * The server url of the shibboleth idp deployment.
     */
    var serverUrl: String? = null

    companion object {
        private const val serialVersionUID = 1741075420882227768L
    }
}
