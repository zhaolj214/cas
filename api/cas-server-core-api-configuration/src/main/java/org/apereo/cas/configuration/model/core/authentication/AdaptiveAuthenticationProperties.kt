package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.ArrayList
import java.util.HashMap

/**
 * This is [AdaptiveAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class AdaptiveAuthenticationProperties : Serializable {
    /**
     * Comma-separated list of strings representing countries to be rejected from participating in authentication transactions.
     */
    var rejectCountries: String? = null

    /**
     * Comma-separated list of strings representing browser user agents to be rejected from participating in authentication transactions.
     */
    var rejectBrowsers: String? = null

    /**
     * Comma-separated list of strings representing IP addresses to be rejected from participating in authentication transactions.
     */
    var rejectIpAddresses: String? = null

    /**
     * Control settings that handle and calculate risky authentication attempts.
     */
    @NestedConfigurationProperty
    var risk = RiskBasedAuthenticationProperties()

    /**
     * A map of (`mfaProviderId -> adaptiveRegexPattern`) that tells CAS when to trigger an MFA authentication transaction.
     *
     *
     * This property binds a valid mfa provider to an adaptive regex pattern representing either IP address, user-agent or geolocation.
     * When either of those collected pieces of adaptive data matches configured regex pattern during authentication event,
     * an MFA authentication transaction is triggered for an MFA provider represented by the map's key.
     *
     *
     * Default value is EMPTY Map.
     */
    var requireMultifactor: Map<String, String> = HashMap()

    /**
     * This property binds a valid mfa provider to a collection of rules that deal with triggering mfa
     * based on that provider based on properties of date/time. One may want to force mfa during weekends,
     * after hours, etc and the ruleset provides a modest configuration set where time can also be treated as trigger.
     */
    var requireTimedMultifactor: List<TimeBasedAuthenticationProperties> = ArrayList()

    companion object {

        private const val serialVersionUID = -1840174229142982880L
    }
}
