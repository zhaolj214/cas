package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties

/**
 * This is [GroovyPrincipalAttributesProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-person-directory", automated = true)
class GroovyPrincipalAttributesProperties : SpringResourceProperties() {
    /**
     * Whether attribute repository should consider the underlying
     * attribute names in a case-insensitive manner.
     */
    var isCaseInsensitive: Boolean = false
    /**
     * The order of this attribute repository in the chain of repositories.
     * Can be used to explicitly position this source in chain and affects
     * merging strategies.
     */
    var order: Int = 0

    companion object {
        private val serialVersionUID = 7901595963842506684L
    }
}
