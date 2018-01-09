package org.apereo.cas.configuration.model.support.spnego

import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [SpnegoProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-spnego-webflow")
class SpnegoProperties : Serializable {
    /**
     * If specified, will create the principal by ths name on successful authentication.
     */
    var isPrincipalWithDomainName: Boolean = false
    /**
     * Allows authentication if spnego credential is marked as NTLM.
     */
    var isNtlmAllowed = true
    /**
     * If the authenticated principal cannot be determined from the spegno credential,
     * will set the http status code to 401.
     */
    var isSend401OnAuthenticationFailure = true

    /**
     * The bean id of a webflow action whose job is to evaluate the client host
     * to see if the request is authorized for spnego.
     * Supported strategies include `hostnameSpnegoClientAction` where
     * CAS checks to see if the request’s remote hostname matches a predefine pattern.
     * and `ldapSpnegoClientAction` where
     * CAS checks an LDAP instance for the remote hostname, to locate a pre-defined attribute whose
     * mere existence would allow the webflow to resume to SPNEGO.
     */
    var hostNameClientActionStrategy = "hostnameSpnegoClientAction"

    /**
     * LDAP settings for spnego to validate clients, etc.
     */
    var ldap = Ldap()

    /**
     * The Jcifs password.
     */
    var jcifsPassword: String? = null
    /**
     * The Jcifs service password.
     */
    var jcifsServicePassword: String? = null
    /**
     * The Jcifs service principal.
     */
    var jcifsServicePrincipal = "HTTP/cas.example.com@EXAMPLE.COM"
    /**
     * The Kerberos conf.
     */
    var kerberosConf: String? = null
    /**
     * The Kerberos kdc.
     */
    var kerberosKdc = "172.10.1.10"
    /**
     * The Kerberos realm.
     */
    var kerberosRealm = "EXAMPLE.COM"
    /**
     * The Login conf.
     */
    var loginConf: String? = null
    /**
     * Spnego JCIFS timeout.
     */
    private var timeout = "PT5M"
    /**
     * Jcifs Netbios cache policy.
     */
    var cachePolicy: Long = 600
    /**
     * The Jcifs netbios wins.
     */
    var jcifsNetbiosWins: String? = null
    /**
     * The Jcifs username.
     */
    var jcifsUsername: String? = null
    /**
     * The Jcifs domain controller.
     */
    var jcifsDomainController: String? = null
    /**
     * The Jcifs domain.
     */
    var jcifsDomain: String? = null
    /**
     * The Kerberos debug.
     */
    var kerberosDebug: String? = null
    /**
     * The Use subject creds only.
     */
    var isUseSubjectCredsOnly: Boolean = false
    /**
     * When validating clients, specifies the DNS timeout used to look up an address.
     */
    private var dnsTimeout = "PT2S"
    /**
     * A regex pattern that indicates whether the client host name is allowed for spnego.
     */
    var hostNamePatternString = ".+"
    /**
     * A regex pattern that indicates whether the client IP is allowed for spnego.
     */
    var ipsToCheckPattern = "127.+"
    /**
     * Alternative header name to use in order to find the host address.
     */
    var alternativeRemoteHostAttribute = "alternateRemoteHeader"
    /**
     * In case LDAP is used to validate clients, this is the attribute that indicates the host.
     */
    var spnegoAttributeName = "distinguishedName"

    /**
     * Determines the header to set and the message prefix when negotiating spnego.
     */
    var isNtlm: Boolean = false
    /**
     * If true, does not terminate authentication and allows CAS to resume
     * and fallback to normal authentication means such as uid/psw via the login page.
     * If disallowed, considers spnego authentication to be final in the event of failures.
     */
    var isMixedModeAuthentication: Boolean = false
    /**
     * Begins negotiating spenego if the user-agent is one of the supported browsers.
     */
    var supportedBrowsers = "MSIE,Trident,Firefox,AppleWebKit"

    /**
     * This is principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Password encoding settings for this authentication.
     */
    @NestedConfigurationProperty
    var principal = PersonDirectoryPrincipalResolverProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    fun getDnsTimeout(): Long {
        return Beans.newDuration(dnsTimeout).toMillis()
    }

    fun setDnsTimeout(dnsTimeout: String) {
        this.dnsTimeout = dnsTimeout
    }

    fun getTimeout(): Long {
        return Beans.newDuration(timeout).toMillis()
    }

    fun setTimeout(timeout: String) {
        this.timeout = timeout
    }

    class Ldap : AbstractLdapSearchProperties() {
        companion object {
            private val serialVersionUID = -8835216200501334936L
        }
    }

    companion object {

        private const val serialVersionUID = 8084143496524446970L
    }
}

