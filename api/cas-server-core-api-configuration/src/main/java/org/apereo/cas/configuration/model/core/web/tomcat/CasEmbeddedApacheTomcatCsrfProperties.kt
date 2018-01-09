package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatCsrfProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatCsrfProperties : Serializable {

    /**
     * Enable filter.
     */
    var isEnabled: Boolean = false

    companion object {
        private const val serialVersionUID = -32143821503580896L
    }
}
