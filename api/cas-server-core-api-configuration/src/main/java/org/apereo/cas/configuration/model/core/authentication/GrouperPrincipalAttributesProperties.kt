package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [GrouperPrincipalAttributesProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-person-directory", automated = true)
class GrouperPrincipalAttributesProperties : Serializable {
    /**
     * The order of this attribute repository in the chain of repositories.
     * Can be used to explicitly position this source in chain and affects
     * merging strategies.
     */
    var order: Int = 0

    /**
     * Enable the attribute repository source.
     */
    var isEnabled: Boolean = false

    companion object {
        private const val serialVersionUID = 7139471665871712818L
    }

}
