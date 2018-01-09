package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule
import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatBasicAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatBasicAuthenticationProperties : Serializable {
    /**
     * Enable the SSL valve for apache tomcat.
     */
    var isEnabled: Boolean = false

    /**
     * Security roles for the CAS application.
     */
    var securityRoles = mutableListOf("admin")

    /**
     * Add an authorization role, which is a role name that will be
     * permitted access to the resources protected by this security constraint.
     */
    var authRoles = mutableListOf("admin")

    /**
     * Add a URL pattern to be part of this web resource collection.
     */
    var patterns = mutableListOf("/*")

    companion object {
        private const val serialVersionUID = 1164446071136700282L
    }
}
