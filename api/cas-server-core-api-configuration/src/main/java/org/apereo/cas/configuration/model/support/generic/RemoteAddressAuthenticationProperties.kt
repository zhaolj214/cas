package org.apereo.cas.configuration.model.support.generic

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * Configuration properties class for remote.authn.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-generic-remote-webflow")
class RemoteAddressAuthenticationProperties : Serializable {
    /**
     * The authorized network address to allow for authentication.
     */
    @RequiredProperty
    var ipAddressRange = StringUtils.EMPTY

    /**
     * The name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = 573409035023089696L
    }
}
