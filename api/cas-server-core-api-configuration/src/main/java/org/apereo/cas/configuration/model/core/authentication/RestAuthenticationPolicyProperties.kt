package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [RestAuthenticationPolicyProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class RestAuthenticationPolicyProperties : Serializable {
    /**
     * Rest endpoint url to contact.
     */
    var endpoint: String? = null

    companion object {
        private const val serialVersionUID = -8979188862774758908L
    }
}
