package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.LinkedHashMap

/**
 * This is [CasEmbeddedApacheTomcatHttpProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatHttpProperties : Serializable {
    /**
     * Enable a separate port for the embedded container for HTTP access.
     */
    var isEnabled: Boolean = false

    /**
     * The HTTP port to use.
     */
    var port = 8080

    /**
     * HTTP protocol to use.
     */
    var protocol = "org.apache.coyote.http11.Http11NioProtocol"

    /**
     * Additional attributes to be set on the connector.
     */
    var attributes: Map<String, Any> = LinkedHashMap()

    companion object {

        private const val serialVersionUID = -8809922027350085888L
    }

}
