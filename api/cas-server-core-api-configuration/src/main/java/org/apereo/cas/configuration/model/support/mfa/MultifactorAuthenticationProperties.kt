package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.Resource

import java.io.Serializable
import java.util.ArrayList

/**
 * Configuration properties class for cas.mfa.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class MultifactorAuthenticationProperties : Serializable {

    /**
     * Attribute returned in the final CAS validation payload
     * that indicates the authentication context class satisified
     * in the event of a multifactor authentication attempt.
     */
    var authenticationContextAttribute = "authnContextClass"
    /**
     * Defines the global failure mode for the entire deployment.
     * This is meant to be used a shortcut to define the policy globally
     * rather than per application. Applications registered with CAS can still
     * define a failure mode and override the global.
     */
    var globalFailureMode = "CLOSED"
    /**
     * MFA can be triggered for a specific authentication request,
     * provided the  request  contains a session/request attribute that indicates the required MFA authentication flow.
     * The attribute name is configurable, but its value must match the authentication provider id of an available MFA provider.
     */
    var sessionAttribute = "authn_method"
    /**
     * MFA can be triggered for a specific authentication request,
     * provided the initial request to the CAS /login endpoint contains a request header that indicates the required MFA authentication flow.
     * The header name is configurable, but its value must match the authentication provider id of an available MFA provider.
     */
    var requestHeader = "authn_method"
    /**
     * MFA can be triggered for a specific authentication request,
     * provided the initial request to the CAS /login endpoint contains a parameter that indicates the required MFA authentication flow.
     * The parameter name is configurable, but its value must match the authentication provider id of an available MFA provider.
     */
    var requestParameter = "authn_method"
    /**
     * MFA can be triggered based on the results of a remote REST endpoint of your design.
     * If the endpoint is configured, CAS shall issue a POST, providing the principal and the service url.
     * The body of the response in the event of a successful 200 status code is
     * expected to be the MFA provider id which CAS should activate.
     */
    var restEndpoint: String? = null

    /**
     * MFA can be triggered based on the results of a groovy script of your own design.
     * The outcome of the script should determine the MFA provider id that CAS should attempt to activate.
     */
    var groovyScript: Resource? = null

    /**
     * This is a more generic variant of the @{link #globalPrincipalAttributeNameTriggers}.
     * It may be useful in cases where there
     * is more than one provider configured and available in the application runtime and
     * you need to design a strategy to dynamically decide on the provider that should be activated for the request.
     * The decision is handed off to a Predicate implementation that define in a Groovy script whose location is taught to CAS.
     */
    var globalPrincipalAttributePredicate: Resource? = null
    /**
     * MFA can be triggered for all users/subjects carrying a specific attribute that matches one of the conditions below.
     *
     *  * Trigger MFA based on a principal attribute(s) whose value(s) matches a regex pattern.
     * Note that this behavior is only applicable if there is only a single MFA provider configured,
     * since that would allow CAS to know what provider to next activate.
     *  * Trigger MFA based on a principal attribute(s) whose value(s) EXACTLY matches an MFA provider.
     * This option is more relevant if you have more than one provider configured or if you have the flexibility
     * of assigning provider ids to attributes as values.
     *
     * Needless to say, the attributes need to have been resolved for the principal prior to this step.
     */
    var globalPrincipalAttributeNameTriggers: String? = null
    /**
     * The regular expression that is cross matches against the principal attribute to determine
     * if the account is qualified for multifactor authentication.
     */
    var globalPrincipalAttributeValueRegex: String? = null

    /**
     * MFA can be triggered for all users/subjects whose authentication event/metadata has resolved a specific attribute that
     * matches one of the below conditions:
     *
     *  * Trigger MFA based on a authentication attribute(s) whose value(s) matches a regex pattern.
     * Note that this behavior is only applicable if there is only a single MFA provider configured,
     * since that would allow CAS to know what provider to next activate.
     *  * Trigger MFA based on a authentication attribute(s) whose value(s) EXACTLY matches an MFA provider.
     * This option is more relevant if you have more than one provider configured or if you have the
     * flexibility of assigning provider ids to attributes as values.
     *
     * Needless to say, the attributes need to have been resolved for the authentication event prior to this step.
     * This trigger is generally useful when the underlying authentication engine signals
     * CAS to perform additional validation of credentials. This signal may be captured by CAS as
     * an attribute that is part of the authentication event metadata which can then trigger
     * additional multifactor authentication events.
     */
    var globalAuthenticationAttributeNameTriggers: String? = null
    /**
     * The regular expression that is cross matches against the authentication attribute to determine
     * if the account is qualified for multifactor authentication.
     */
    var globalAuthenticationAttributeValueRegex: String? = null

    /**
     * Content-type that is expected to be specified by non-web clients such as curl, etc in the
     * event that the provider supports variations of non-browser based MFA.
     */
    var contentType = "application/cas"
    /**
     * MFA can be triggered for all applications and users regardless of individual settings.
     * This setting holds the value of an MFA provider that shall be activated for all requests,
     * regardless.
     */
    var globalProviderId: String? = null

    /**
     * MFA can be triggered by Grouper groups to which the authenticated principal is assigned.
     * Groups are collected by CAS and then cross-checked against all available/configured MFA providers.
     * The group’s comparing factor MUST be defined in CAS to activate this behavior and
     * it can be based on the group’s name, display name,
     * etc where a successful match against a provider id shall activate the chosen MFA provider.
     */
    var grouperGroupField: String? = null
    /**
     * In the event that multiple multifactor authentication providers are determined for a multifactor authentication transaction,
     * by default CAS will attempt to sort the collection of providers based on their rank and
     * will pick one with the highest priority. This use case may arise if multiple triggers
     * are defined where each decides on a different multifactor authentication provider, or
     * the same provider instance is configured multiple times with many instances.
     * Provider selection may also be carried out using Groovy scripting strategies more dynamically.
     * The following example should serve as an outline of how to select multifactor providers based on a Groovy script.
     */
    var providerSelectorGroovyScript: Resource? = null

    /**
     * Activate and configure a multifactor authentication provider via U2F FIDO.
     */
    @NestedConfigurationProperty
    var u2f = U2FMultifactorProperties()

    /**
     * Activate and configure a multifactor authentication provider via Microsoft Azure.
     */
    @NestedConfigurationProperty
    var azure = AzureMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication with the capability to trust and remember devices.
     */
    @NestedConfigurationProperty
    var trusted = TrustedDevicesMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication provider via YubiKey.
     */
    @NestedConfigurationProperty
    var yubikey = YubiKeyMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication provider via RADIUS.
     */
    @NestedConfigurationProperty
    var radius = RadiusMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication provider via Google Authenticator.
     */
    @NestedConfigurationProperty
    var gauth = GAuthMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication provider via Duo Security.
     */
    var duo: List<DuoSecurityMultifactorProperties> = ArrayList()
    /**
     * Activate and configure a multifactor authentication provider via Authy.
     */
    @NestedConfigurationProperty
    var authy = AuthyMultifactorProperties()
    /**
     * Activate and configure a multifactor authentication provider via Swivel.
     */
    @NestedConfigurationProperty
    var swivel = SwivelMultifactorProperties()

    companion object {
        private const val serialVersionUID = 7416521468929733907L
    }
}
