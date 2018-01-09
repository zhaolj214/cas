package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.LinkedHashMap

/**
 * This is [CasEmbeddedApacheTomcatHttpProxyProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatHttpProxyProperties : Serializable {
    /**
     * Enable the container running in proxy mode.
     */
    var isEnabled: Boolean = false
    /**
     * Scheme used for the proxy.
     */
    var scheme = "https"
    /**
     * Whether proxy should run in secure mode.
     */
    var isSecure = true
    /**
     * Redirect port for the proxy.
     */
    var redirectPort: Int = 0
    /**
     * Proxy port for the proxy.
     */
    var proxyPort: Int = 0
    /**
     * Proxy protocol to use.
     */
    var protocol = "AJP/1.3"
    /**
     * Custom attributes to set on the proxy connector.
     */
    var attributes: Map<String, Any> = LinkedHashMap()

    companion object {
        private const val serialVersionUID = 9129851352067677264L
    }
}
