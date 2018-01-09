package org.apereo.cas.configuration.model.support.oauth

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [OAuthGrantsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-oauth")
class OAuthGrantsProperties : Serializable {
    /**
     * Resource owner grant settings.
     */
    var resourceOwner = ResourceOwner()

    @RequiresModule(name = "cas-server-support-oauth")
    class ResourceOwner : Serializable {
        /**
         * Whether using the resource-owner grant should
         * enforce authorization rules and per-service policies
         * based on a service parameter is provided as a header
         * outside the normal semantics of the grant and protocol.
         */
        var isRequireServiceHeader: Boolean = false

        companion object {
            private const val serialVersionUID = 3171206304518294330L
        }
    }

    companion object {
        private const val serialVersionUID = -2246860215082703251L
    }
}
