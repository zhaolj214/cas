package org.apereo.cas.configuration.model.support.oauth

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [OAuthAccessTokenProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-oauth")
class OAuthAccessTokenProperties : Serializable {
    /**
     * Hard timeout to kill the access token and expire it.
     */
    private var maxTimeToLiveInSeconds = "PT28800S"
    /**
     * Sliding window for the access token expiration policy.
     * Essentially, this is an idle time out.
     */
    private var timeToKillInSeconds = "PT7200S"
    /**
     * Whether CAS authentication/protocol attributes
     * should be released as part of this access token's validation.
     */
    var isReleaseProtocolAttributes = true

    fun getMaxTimeToLiveInSeconds(): Long {
        return Beans.newDuration(maxTimeToLiveInSeconds).seconds
    }

    fun setMaxTimeToLiveInSeconds(maxTimeToLiveInSeconds: String) {
        this.maxTimeToLiveInSeconds = maxTimeToLiveInSeconds
    }

    fun getTimeToKillInSeconds(): Long {
        return Beans.newDuration(timeToKillInSeconds).seconds
    }

    fun setTimeToKillInSeconds(timeToKillInSeconds: String) {
        this.timeToKillInSeconds = timeToKillInSeconds
    }

    companion object {
        private const val serialVersionUID = -6832081675586528350L
    }
}
