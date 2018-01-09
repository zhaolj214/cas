package org.apereo.cas.configuration.model.support.oauth

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [OAuthRefreshTokenProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-oauth")
class OAuthRefreshTokenProperties : Serializable {
    /**
     * Hard timeout beyond which the refresh token is considered expired.
     */
    private var timeToKillInSeconds = "P14D"

    fun getTimeToKillInSeconds(): Long {
        return Beans.newDuration(timeToKillInSeconds).seconds
    }

    fun setTimeToKillInSeconds(timeToKillInSeconds: String) {
        this.timeToKillInSeconds = timeToKillInSeconds
    }

    companion object {
        private const val serialVersionUID = -8328568272835831702L
    }
}
