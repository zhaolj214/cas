package org.apereo.cas.configuration.model.core

import org.apereo.cas.CasProtocolConstants
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatAjpProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatBasicAuthenticationProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatCsrfProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatExtendedAccessLogProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatHttpProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatHttpProxyProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatRemoteAddressProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatRewriteValveProperties
import org.apereo.cas.configuration.model.core.web.tomcat.CasEmbeddedApacheTomcatSslValveProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [CasServerProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core", automated = true)
class CasServerProperties : Serializable {

    /**
     * Full name of the CAS server. This is public-facing address
     * of the CAS deployment and not the individual node address,
     * in the event that CAS is clustered.
     */
    @RequiredProperty
    var name = "https://cas.example.org:8443"
    /**
     * A concatenation of the server name plus the CAS context path.
     * Deployments at root likely need to blank out this value.
     */
    @RequiredProperty
    var prefix = name + "/cas"
    /**
     * Embedded container AJP settings.
     */
    @NestedConfigurationProperty
    var ajp = CasEmbeddedApacheTomcatAjpProperties()
    /**
     * Embedded container HTTP port settings as an additional option.
     */
    @NestedConfigurationProperty
    var http = CasEmbeddedApacheTomcatHttpProperties()
    /**
     * Http proxy configuration properties.
     * In the event that you decide to run CAS without any SSL configuration in the embedded Tomcat container and on a non-secure
     * port yet wish to customize the connector configuration that is linked to the running port (i.e. 8080), this setting may apply.
     */
    @NestedConfigurationProperty
    var httpProxy = CasEmbeddedApacheTomcatHttpProxyProperties()
    /**
     * Embedded container's SSL valve setting.
     */
    @NestedConfigurationProperty
    var sslValve = CasEmbeddedApacheTomcatSslValveProperties()
    /**
     * Embedded container's rewrite valve setting.
     */
    @NestedConfigurationProperty
    var rewriteValve = CasEmbeddedApacheTomcatRewriteValveProperties()
    /**
     * Configuration properties for access logging beyond defaults.
     */
    @NestedConfigurationProperty
    var extAccessLog = CasEmbeddedApacheTomcatExtendedAccessLogProperties()

    /**
     * Enable Tomcat's RemoteAddress filter.
     */
    @NestedConfigurationProperty
    var remoteAddr = CasEmbeddedApacheTomcatRemoteAddressProperties()

    /**
     * Enable Tomcat's CSRF filter.
     */
    @NestedConfigurationProperty
    var csrf = CasEmbeddedApacheTomcatCsrfProperties()

    /**
     * Enable basic authentication for the embedded tomcat.
     */
    @NestedConfigurationProperty
    var basicAuthn = CasEmbeddedApacheTomcatBasicAuthenticationProperties()

    val loginUrl: String
        get() = prefix + CasProtocolConstants.ENDPOINT_LOGIN

    val logoutUrl: String
        get() = prefix + CasProtocolConstants.ENDPOINT_LOGOUT

    companion object {
        private const val serialVersionUID = 7876382696803430817L
    }
}
