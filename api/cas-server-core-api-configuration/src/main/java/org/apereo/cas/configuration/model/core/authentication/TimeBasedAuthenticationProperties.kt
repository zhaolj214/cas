package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [TimeBasedAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class TimeBasedAuthenticationProperties : Serializable {

    /**
     * The mfa provider id that should be triggered.
     */
    var providerId: String? = null

    /**
     * Trigger mfa after this hour, specified in 24-hour format.
     */
    var onOrAfterHour: Long = 20

    /**
     * Trigger mfa before this hour, specified in 24-hour format.
     */
    var onOrBeforeHour: Long = 7

    /**
     * Trigger mfa on the following days of the week.
     */
    var onDays: List<String> = ArrayList()

    companion object {
        private const val serialVersionUID = 3826749727400569308L
    }
}
