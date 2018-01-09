package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.model.support.cassandra.authentication.CassandraAuthenticationProperties
import org.apereo.cas.configuration.model.support.clouddirectory.CloudDirectoryProperties
import org.apereo.cas.configuration.model.support.couchbase.authentication.CouchbaseAuthenticationProperties
import org.apereo.cas.configuration.model.support.digest.DigestProperties
import org.apereo.cas.configuration.model.support.fortress.FortressAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.AcceptAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.FileAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.JsonResourceAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.RejectAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.RemoteAddressAuthenticationProperties
import org.apereo.cas.configuration.model.support.generic.ShiroAuthenticationProperties
import org.apereo.cas.configuration.model.support.gua.GraphicalUserAuthenticationProperties
import org.apereo.cas.configuration.model.support.jaas.JaasAuthenticationProperties
import org.apereo.cas.configuration.model.support.jdbc.JdbcAuthenticationProperties
import org.apereo.cas.configuration.model.support.ldap.LdapAuthenticationProperties
import org.apereo.cas.configuration.model.support.mfa.MultifactorAuthenticationProperties
import org.apereo.cas.configuration.model.support.mongo.MongoAuthenticationProperties
import org.apereo.cas.configuration.model.support.ntlm.NtlmProperties
import org.apereo.cas.configuration.model.support.oauth.OAuthProperties
import org.apereo.cas.configuration.model.support.oidc.OidcProperties
import org.apereo.cas.configuration.model.support.openid.OpenIdProperties
import org.apereo.cas.configuration.model.support.pac4j.Pac4jProperties
import org.apereo.cas.configuration.model.support.pm.PasswordManagementProperties
import org.apereo.cas.configuration.model.support.radius.RadiusProperties
import org.apereo.cas.configuration.model.support.rest.RestAuthenticationProperties
import org.apereo.cas.configuration.model.support.saml.idp.SamlIdPProperties
import org.apereo.cas.configuration.model.support.saml.shibboleth.ShibbolethIdPProperties
import org.apereo.cas.configuration.model.support.spnego.SpnegoProperties
import org.apereo.cas.configuration.model.support.surrogate.SurrogateAuthenticationProperties
import org.apereo.cas.configuration.model.support.syncope.SyncopeAuthenticationProperties
import org.apereo.cas.configuration.model.support.throttle.ThrottleProperties
import org.apereo.cas.configuration.model.support.token.TokenAuthenticationProperties
import org.apereo.cas.configuration.model.support.trusted.TrustedAuthenticationProperties
import org.apereo.cas.configuration.model.support.wsfed.WsFederationDelegationProperties
import org.apereo.cas.configuration.model.support.wsfed.WsFederationProperties
import org.apereo.cas.configuration.model.support.x509.X509Properties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [AuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class AuthenticationProperties : Serializable {

    /**
     * JSON authentication settings.
     */
    @NestedConfigurationProperty
    var json = JsonResourceAuthenticationProperties()

    /**
     * Syncope authentication settings.
     */
    @NestedConfigurationProperty
    var syncope = SyncopeAuthenticationProperties()

    /**
     * Couchbase authentication settings.
     */
    @NestedConfigurationProperty
    var couchbase = CouchbaseAuthenticationProperties()

    /**
     * Cassandra authentication settings.
     */
    @NestedConfigurationProperty
    var cassandra = CassandraAuthenticationProperties()

    /**
     * Cloud Directory authentication settings.
     */
    @NestedConfigurationProperty
    var cloudDirectory = CloudDirectoryProperties()

    /**
     * Surrogate authentication settings.
     */
    @NestedConfigurationProperty
    var surrogate = SurrogateAuthenticationProperties()

    /**
     * Graphical User authentication settings.
     */
    @NestedConfigurationProperty
    var gua = GraphicalUserAuthenticationProperties()

    /**
     * Password management settings.
     */
    @NestedConfigurationProperty
    var pm = PasswordManagementProperties()

    /**
     * Adaptive authentication settings.
     */
    @NestedConfigurationProperty
    var adaptive = AdaptiveAuthenticationProperties()

    /**
     * Attribute repository settings.
     */
    @NestedConfigurationProperty
    var attributeRepository = PrincipalAttributesProperties()

    /**
     * Digest authentication settings.
     */
    @NestedConfigurationProperty
    var digest = DigestProperties()

    /**
     * REST-based authentication settings.
     */
    @NestedConfigurationProperty
    var rest = RestAuthenticationProperties()

    /**
     * Collection of settings related to LDAP authentication.
     * These settings are required to be indexed (i.e. ldap[0].xyz).
     */
    var ldap: List<LdapAuthenticationProperties> = ArrayList()

    /**
     * Authentication throttling settings.
     */
    @NestedConfigurationProperty
    var throttle = ThrottleProperties()

    /**
     * SAML identity provider settings.
     */
    @NestedConfigurationProperty
    var samlIdp = SamlIdPProperties()

    /**
     * Customization of authentication errors and exceptions.
     */
    @NestedConfigurationProperty
    var exceptions = AuthenticationExceptionsProperties()

    /**
     * Authentication policy settings.
     */
    @NestedConfigurationProperty
    var policy = AuthenticationPolicyProperties()

    /**
     * Accepting authentication based on statically defined users.
     */
    @NestedConfigurationProperty
    var accept = AcceptAuthenticationProperties()

    /**
     * File-based authentication.
     */
    @NestedConfigurationProperty
    var file = FileAuthenticationProperties()

    /**
     * Blacklist-based authentication.
     */
    @NestedConfigurationProperty
    var reject = RejectAuthenticationProperties()

    /**
     * Authentication based on a remote-address of a request.
     */
    @NestedConfigurationProperty
    var remoteAddress = RemoteAddressAuthenticationProperties()

    /**
     * Authentication settings when integrating CAS with a shibboleth IdP.
     */
    @NestedConfigurationProperty
    var shibIdp = ShibbolethIdPProperties()

    /**
     * Shiro-based authentication.
     */
    @NestedConfigurationProperty
    var shiro = ShiroAuthenticationProperties()

    /**
     * Trusted authentication.
     */
    @NestedConfigurationProperty
    var trusted = TrustedAuthenticationProperties()

    /**
     * Collection of settings related to JAAS authentication.
     * These settings are required to be indexed (i.e. jaas[0].xyz).
     */
    var jaas: List<JaasAuthenticationProperties> = ArrayList()

    /**
     * JDBC authentication settings.
     */
    @NestedConfigurationProperty
    var jdbc = JdbcAuthenticationProperties()

    /**
     * MFA settings.
     */
    @NestedConfigurationProperty
    var mfa = MultifactorAuthenticationProperties()

    /**
     * MongoDb authentication settings.
     */
    @NestedConfigurationProperty
    var mongo = MongoAuthenticationProperties()

    /**
     * NTLM authentication settings.
     */
    @NestedConfigurationProperty
    var ntlm = NtlmProperties()

    /**
     * OAuth authentication settings.
     */
    @NestedConfigurationProperty
    var oauth = OAuthProperties()

    /**
     * OpenID Connect authentication settings.
     */
    @NestedConfigurationProperty
    var oidc = OidcProperties()

    /**
     * OpenID authentication settings.
     */
    @NestedConfigurationProperty
    var openid = OpenIdProperties()

    /**
     * Pac4j delegated authentication settings.
     */
    @NestedConfigurationProperty
    var pac4j = Pac4jProperties()

    /**
     * RADIUS authentication settings.
     */
    @NestedConfigurationProperty
    var radius = RadiusProperties()

    /**
     * SPNEGO authentication settings.
     */
    @NestedConfigurationProperty
    var spnego = SpnegoProperties()

    /**
     * Collection of settings related to WsFed delegated authentication.
     * These settings are required to be indexed (i.e. wsfed[0].xyz).
     */
    var wsfed: List<WsFederationDelegationProperties> = ArrayList()

    /**
     * WS-FED IdP authentication settings.
     */
    @NestedConfigurationProperty
    var wsfedIdp = WsFederationProperties()

    /**
     * X509 authentication settings.
     */
    @NestedConfigurationProperty
    var x509 = X509Properties()

    /**
     * Token/JWT authentication settings.
     */
    @NestedConfigurationProperty
    var token = TokenAuthenticationProperties()

    /**
     * Apache Fortress authentication settings.
     */
    @NestedConfigurationProperty
    var fortress = FortressAuthenticationProperties()

    /**
     * Authentication attribute release settings.
     */
    @NestedConfigurationProperty
    var authenticationAttributeRelease = AuthenticationAttributeReleaseProperties()

    /**
     * Whether CAS authentication/protocol attributes
     * should be released as part of ticket validation.
     */
    var isReleaseProtocolAttributes = true

    companion object {

        private const val serialVersionUID = -1233126985007049516L
    }
}
