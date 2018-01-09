package org.apereo.cas.configuration.model.support.openid

import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [OpenIdProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-openid")
class OpenIdProperties : Serializable {
    /**
     * Principal construction settings.
     */
    @NestedConfigurationProperty
    var principal = PersonDirectoryPrincipalResolverProperties()

    /**
     * Whether relying party identifies should be enforced.
     * This is used during the realm verification process.
     */
    var isEnforceRpId: Boolean = false

    /**
     * Name of the underlying authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = -2935759289483632610L
    }
}

