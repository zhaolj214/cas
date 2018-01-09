package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RestEndpointProperties

/**
 * This is [RestPrincipalAttributesProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-person-directory", automated = true)
class RestPrincipalAttributesProperties : RestEndpointProperties() {
    /**
     * The order of this attribute repository in the chain of repositories.
     * Can be used to explicitly position this source in chain and affects
     * merging strategies.
     */
    var order: Int = 0

    /**
     * Whether attribute repository should consider the underlying
     * attribute names in a case-insensitive manner.
     */
    var isCaseInsensitive: Boolean = false

    companion object {
        private val serialVersionUID = -30055974448426360L
    }
}
