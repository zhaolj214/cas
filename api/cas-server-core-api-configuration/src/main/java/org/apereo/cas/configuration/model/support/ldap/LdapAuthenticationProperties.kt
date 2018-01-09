package org.apereo.cas.configuration.model.support.ldap

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PasswordPolicyProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [LdapAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-ldap")
class LdapAuthenticationProperties : AbstractLdapAuthenticationProperties() {
    /**
     * Password policy settings.
     */
    @NestedConfigurationProperty
    var passwordPolicy = PasswordPolicyProperties()

    /**
     * Principal transformation settings.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Password encoder settings for LDAP authentication.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * A number of authentication handlers are allowed to determine whether they can operate on the provided credential
     * and as such lend themselves to be tried and tested during the authentication handler selection phase.
     * The credential criteria may be one of the following options:
     *  * 1) A regular expression pattern that is tested against the credential identifier.
     *  * 2) A fully qualified class name of your own design that implements `Predicate<Credential>`.
     *  * 3) Path to an external Groovy script that implements the same interface.
     *
     */
    var credentialCriteria: String? = null

    /**
     * The attribute to use as the principal identifier built during and upon a successful authentication attempt.
     */
    var principalAttributeId: String? = null

    /**
     * Name of attribute to be used for principal's DN.
     */
    var principalDnAttributeName = "principalLdapDn"

    /**
     * List of attributes to retrieve from LDAP.
     * Attributes can be virtually remapped to multiple names.
     * Example `cn:commonName,givenName,eduPersonTargettedId:SOME_IDENTIFIER`
     */
    var principalAttributeList = mutableListOf<String>()

    /**
     * Sets a flag that determines whether multiple values are allowed for the [.principalAttributeId].
     * This flag only has an effect if [.principalAttributeId] is configured. If multiple values are detected
     * when the flag is false, the first value is used and a warning is logged. If multiple values are detected
     * when the flag is true, an exception is raised.
     *
     */
    var isAllowMultiplePrincipalAttributeValues: Boolean = false

    /**
     * List of additional attributes to retrieve, if any.
     */
    var additionalAttributes = mutableListOf<String>()

    /**
     * Flag to indicate whether CAS should block authentication
     * if a specific/configured principal id attribute is not found.
     */
    var isAllowMissingPrincipalAttributeValue = true

    /**
     * When entry DN should be called as an attribute and stored into the principal.
     */
    var isCollectDnAttribute: Boolean = false

    /**
     * Order of the authentication handler in the chain.
     */
    var order: Int? = null

    companion object {

        private val serialVersionUID = -5357843463521189892L
    }
}
