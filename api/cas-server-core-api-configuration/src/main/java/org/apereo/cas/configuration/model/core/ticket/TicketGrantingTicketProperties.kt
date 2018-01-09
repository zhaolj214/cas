package org.apereo.cas.configuration.model.core.ticket

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [TicketGrantingTicketProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class TicketGrantingTicketProperties : Serializable {
    /**
     * Maximum length of TGTs.
     */
    var maxLength = 50

    /**
     * Maximum time in seconds TGTs would be live in CAS server.
     */
    var maxTimeToLiveInSeconds = 28800

    /**
     * Time in seconds after which TGTs would be destroyed after a period of inactivity.
     */
    var timeToKillInSeconds = 7200

    /**
     * Flag to control whether to track most recent SSO sessions.
     * As multiple tickets may be issued for the same application, this impacts
     * how session information is tracked for every ticket which then
     * has a subsequent impact on logout.
     */
    var isOnlyTrackMostRecentSession = true

    /**
     * Hard timeout for TGTs.
     */
    var hardTimeout = HardTimeout()

    /**
     * Throttled timeout for TGTs.
     */
    var throttledTimeout = ThrottledTimeout()

    /**
     * Timeout for TGTs.
     */
    var timeout = Timeout()

    /**
     * Remember me for TGTs.
     */
    var rememberMe = RememberMe()

    class HardTimeout : Serializable {
        /**
         * Timeout in seconds to kill the session and consider tickets expired.
         */
        var timeToKillInSeconds: Long = 0

        companion object {
            private const val serialVersionUID = 4160963910346416908L
        }
    }

    class Timeout : Serializable {
        /**
         * Maximum time in seconds. for TGTs to be live in CAS server.
         */
        var maxTimeToLiveInSeconds: Int = 0

        companion object {

            private const val serialVersionUID = 8635419913795245907L
        }
    }

    class ThrottledTimeout : Serializable {
        /**
         * Timeout in seconds to kill the session and consider tickets expired.
         */
        var timeToKillInSeconds: Long = 0
        /**
         * Timeout in between each attempt.
         */
        var timeInBetweenUsesInSeconds: Long = 0

        companion object {
            private const val serialVersionUID = -2370751379747804646L
        }
    }

    class RememberMe : Serializable {
        /**
         * Flag to indicate whether remember-me facility is enabled.
         */
        var isEnabled: Boolean = false

        /**
         * Time in seconds after which remember-me enabled SSO session will be destroyed.
         */
        var timeToKillInSeconds: Long = 1209600

        companion object {

            private const val serialVersionUID = 1899959269597512610L
        }
    }

    companion object {

        private const val serialVersionUID = 2349079252583399336L
    }
}
