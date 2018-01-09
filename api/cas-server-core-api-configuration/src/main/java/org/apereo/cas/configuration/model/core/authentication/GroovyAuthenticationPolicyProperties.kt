package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [GroovyAuthenticationPolicyProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class GroovyAuthenticationPolicyProperties : Serializable {
    /**
     * Path to the groovy script to execute.
     */
    var script: String? = null

    companion object {
        private const val serialVersionUID = 8713917167124116270L
    }
}
