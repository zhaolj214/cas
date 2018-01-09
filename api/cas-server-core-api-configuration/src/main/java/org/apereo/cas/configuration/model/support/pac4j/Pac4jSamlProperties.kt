package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [Pac4jSamlProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
class Pac4jSamlProperties : Serializable {

    /**
     * The destination binding to use
     * when creating authentication requests.
     */
    var destinationBinding = "urn:oasis:names:tc:SAML:2.0:bindings:HTTP-Redirect"

    /**
     * The password to use when generating the SP/CAS keystore.
     */
    @RequiredProperty
    var keystorePassword: String? = null
    /**
     * The password to use when generating the private key for the SP/CAS keystore.
     */
    @RequiredProperty
    var privateKeyPassword: String? = null
    /**
     * Location of the keystore to use and generate the SP/CAS keystore.
     */
    @RequiredProperty
    var keystorePath: String? = null
    /**
     * The metadata location of the identity provider that is to handle authentications.
     */
    @RequiredProperty
    var identityProviderMetadataPath: String? = null
    /**
     * Once you have an authenticated session on the identity provider, usually it won't prompt you again to enter your
     * credentials and it will automatically generate a new assertion for you. By default, the SAML client
     * will accept assertions based on a previous authentication for one hour.
     * You can adjust this behavior by modifying this setting. The unit of time here is seconds.
     */
    var maximumAuthenticationLifetime = 600

    /**
     * The entity id of the SP/CAS that is used in the SP metadata generation process.
     */
    @RequiredProperty
    var serviceProviderEntityId: String? = null
    /**
     * Location of the SP metadata to use and generate.
     */
    @RequiredProperty
    var serviceProviderMetadataPath: String? = null

    /**
     * Name of the SAML client mostly for UI purposes and uniqueness.
     * This name, with 'nonword' characters converted to '-' (e.g. "This Org (New)" becomes "This-Org--New-")
     * is added to the "class" atribute of the redirect link on the login page, to allow for
     * custom styling of individual IdPs (e.g. for an organization logo).
     */
    var clientName: String? = null

    /**
     * Whether authentication requests should be tagged as forced auth.
     */
    var isForceAuth: Boolean = false
    /**
     * Whether authentication requests should be tagged as passive.
     */
    var isPassive: Boolean = false

    /**
     * Requested authentication context class in authn requests.
     */
    var authnContextClassRef: String? = null
    /**
     * Specifies the comparison rule that should be used to evaluate the specified authentication methods.
     * For example, if exact is specified, the authentication method used must match one of the authentication
     * methods specified by the AuthnContextClassRef elements.
     * AuthContextClassRef element require comparison rule to be used to evaluate the specified
     * authentication methods. If not explicitly specified "exact" rule will be used by default.
     * Other acceptable values are minimum, maximum, better.
     */
    var authnContextComparisonType = "exact"

    /**
     * The key alias used in the keystore.
     */
    var keystoreAlias: String? = null
    /**
     * NameID policy to request in the authentication requests.
     */
    var nameIdPolicyFormat: String? = null
    /**
     * Whether metadata should be marked to request sign assertions.
     */
    var isWantsAssertionsSigned: Boolean = false

    companion object {
        private const val serialVersionUID = -862819796533384951L
    }
}

