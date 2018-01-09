package org.apereo.cas.configuration.model.support.oauth

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [OAuthCodeProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-oauth")
class OAuthCodeProperties : Serializable {
    /**
     * Number of times this code is valid and can be used.
     */
    var numberOfUses = 1
    /**
     * Duration in seconds where the code is valid.
     */
    var timeToKillInSeconds: Long = 30

    companion object {
        private const val serialVersionUID = -7687928082301669359L
    }
}
