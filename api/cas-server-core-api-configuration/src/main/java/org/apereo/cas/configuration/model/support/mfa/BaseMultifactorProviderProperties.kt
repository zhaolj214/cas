package org.apereo.cas.configuration.model.support.mfa

import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [BaseMultifactorProviderProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
abstract class BaseMultifactorProviderProperties : Serializable {
    /**
     * At times, CAS needs to determine the correct provider when step-up authentication is required.
     * Consider for a moment that CAS already has established an SSO session with/without a provider and has
     * reached a level of authentication. Another incoming request attempts to exercise that SSO
     * session with a different and often competing authentication requirement that may differ from the
     * authentication level CAS has already established. Concretely, examples may be:
     *
     *  * CAS has achieved an SSO session, but a separate request now requires step-up authentication with DuoSecurity.
     *  * CAS has achieved an SSO session with an authentication level satisfied by DuoSecurity,
     * but a separate request now requires step-up authentication with YubiKey.
     *
     * In certain scenarios, CAS will attempt to rank authentication levels and compare them with each other.
     * If CAS already has achieved a level that is higher than what the incoming request requires,
     * no step-up authentication will be performed. If the opposite is true, CAS will route the authentication
     * flow to the required authentication level and upon success, will adjust the SSO session with the
     * new higher authentication level now satisfied.
     *
     *
     * Ranking of authentication methods is done per provider via specific properties for each.
     * Note that the higher the rank value is, the higher on the security scale it remains.
     * A provider that ranks higher with a larger weight value trumps and override others with a lower value.
     *
     */
    var rank: Int = 0
    /**
     * The identifier for the multifactor provider.
     * In most cases, this need not be configured explicitly, unless
     * multiple instances of the same provider type are configured in CAS.
     */
    var id: String? = null
    /**
     * Multifactor bypass options for this provider.
     * Each multifactor provider is equipped with options to allow for MFA bypass. Once the provider is chosen to honor
     * the authentication request, bypass rules are then consulted to calculate whether the provider
     * should ignore the request and skip MFA conditionally.
     */
    @NestedConfigurationProperty
    var bypass = MultifactorAuthenticationProviderBypassProperties()
    /**
     * The name of the authentication handler used to verify credentials in MFA.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = -2690281104343633871L
    }

}

