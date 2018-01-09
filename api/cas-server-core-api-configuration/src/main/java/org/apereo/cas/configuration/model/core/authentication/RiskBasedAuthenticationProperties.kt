package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.model.support.email.EmailProperties
import org.apereo.cas.configuration.model.support.sms.SmsProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [RiskBasedAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-electrofence", automated = true)
class RiskBasedAuthenticationProperties : Serializable {
    /**
     * Handle risky authentication attempts via an IP criteria.
     */
    var ip = IpAddress()

    /**
     * Handle risky authentication attempts via a user-agent criteria.
     */
    var agent = Agent()

    /**
     * Handle risky authentication attempts via geolocation criteria.
     */
    var geoLocation = GeoLocation()

    /**
     * Handle risky authentication attempts via an date/time criteria.
     */
    var dateTime = DateTime()

    /**
     * Design how responses should be handled, in the event
     * that an authentication event is deemed risky.
     */
    var response = Response()

    /**
     * The risk threshold factor beyond which the authentication
     * event may be considered risky.
     */
    var threshold = 0.6

    /**
     * Indicates how far back the search in authentication history must go
     * in order to locate authentication events.
     */
    var daysInRecentHistory: Long = 30

    class IpAddress : Serializable {
        /**
         * Enable IP address checking and criteria
         * to calculate risky authentication attempts.
         */
        var isEnabled: Boolean = false

        companion object {
            private const val serialVersionUID = 577801361041617794L
        }
    }

    class Agent : Serializable {
        /**
         * Enable user-agent checking and criteria
         * to calculate risky authentication attempts.
         */
        var isEnabled: Boolean = false

        companion object {

            private const val serialVersionUID = 7766080681971729400L
        }
    }

    class GeoLocation : Serializable {
        /**
         * Enable geolocation checking and criteria
         * to calculate risky authentication attempts.
         */
        var isEnabled: Boolean = false

        companion object {

            private const val serialVersionUID = 4115333388680538358L
        }
    }

    class DateTime : Serializable {
        /**
         * Enable date/time checking and criteria
         * to calculate risky authentication attempts.
         */
        var isEnabled: Boolean = false

        /**
         * The hourly window used before and after each authentication event
         * in calculation to establish a pattern that can then be compared against the threshold.
         */
        var windowInHours = 2

        companion object {

            private const val serialVersionUID = -3776875583039922050L
        }
    }

    class Response : Serializable {
        /**
         * If an authentication attempt is deemed risky, block the response
         * and do not allow further attempts.
         */
        var isBlockAttempt: Boolean = false

        /**
         * If an authentication attempt is deemed risky, force
         * a multi-factor authentication event noted by the provider id here.
         */
        var mfaProvider: String? = null

        /**
         * If an authentication attempt is deemed risky, communicate the nature of
         * this attempt back to the application via a special attribute
         * in the final CAS response indicated here.
         */
        var riskyAuthenticationAttribute = "triggeredRiskBasedAuthentication"

        /**
         * Email settings for notifications,
         * If an authentication attempt is deemed risky.
         */
        @NestedConfigurationProperty
        var mail = EmailProperties()

        /**
         * SMS settings for notifications,
         * If an authentication attempt is deemed risky.
         */
        @NestedConfigurationProperty
        var sms = SmsProperties()

        companion object {

            private const val serialVersionUID = 8254082561120701582L
        }
    }

    companion object {

        private const val serialVersionUID = 3826749727400569308L
    }
}
