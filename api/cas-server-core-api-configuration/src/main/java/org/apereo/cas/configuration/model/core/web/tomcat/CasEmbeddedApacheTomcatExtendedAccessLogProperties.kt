package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatExtendedAccessLogProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatExtendedAccessLogProperties : Serializable {
    /**
     * Flag to indicate whether extended log facility is enabled.
     */
    var isEnabled: Boolean = false

    /**
     * String representing extended log pattern.
     */
    var pattern = "c-ip s-ip cs-uri sc-status time x-threadname x-H(secure) x-H(remoteUser)"

    /**
     * File name suffix for extended log.
     */
    var suffix = ".log"

    /**
     * File name prefix for extended log.
     */
    var prefix = "localhost_access_extended"

    /**
     * Directory name for extended log.
     */
    var directory: String? = null

    companion object {
        private const val serialVersionUID = 6738161402499196038L
    }
}
