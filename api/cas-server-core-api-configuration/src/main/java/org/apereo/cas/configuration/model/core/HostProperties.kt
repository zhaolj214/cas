package org.apereo.cas.configuration.model.core

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * Configuration properties class for host.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core", automated = true)
class HostProperties : Serializable {
    /**
     * Name of the networking host configured to run CAS server.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = 8624916460241033347L
    }
}
